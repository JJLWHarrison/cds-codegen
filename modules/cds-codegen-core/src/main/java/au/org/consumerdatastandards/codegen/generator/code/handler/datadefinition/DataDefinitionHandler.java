package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;
import org.apache.velocity.script.VelocityScriptEngine;
import org.apache.velocity.script.VelocityScriptEngineFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.code.CodeGenerator;
import au.org.consumerdatastandards.codegen.generator.code.TargetConfigModel;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.openapi.SwaggerGeneratorOptions;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

public class DataDefinitionHandler extends AbstractHandler<DataDefinitionHandlerConfig> {
    private static final Logger LOG = LogManager.getLogger(DataDefinitionHandler.class);

    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof DataDefinitionHandlerConfig;
    }

    public List<DataDefinitionModel> collectDataDefinitions() {
        List<DataDefinitionModel> dataDefinitions = new ArrayList<DataDefinitionModel>();
        for (Class<?> definitionClass : codegenModel.getDataDefinitions()) {
            DataDefinitionModel oneDataDefinition = new DataDefinitionModel();
            oneDataDefinition.definitionName = definitionClass.getSimpleName();
            oneDataDefinition.packageName = definitionClass.getPackage().getName();
            
            Field[] definitionFields = definitionClass.getDeclaredFields();
            for (Field oneField : definitionFields) {
                oneField.setAccessible(true);
                DataDefinitionModelField oneModelField = new DataDefinitionModelField();
                oneModelField.name = oneField.getName();
                oneModelField.type = oneField.getType().getSimpleName();                
                oneDataDefinition.fieldList.add(oneModelField);
            }

            dataDefinitions.add(oneDataDefinition);
        }
        return dataDefinitions;
    }

    @Override
    public void setConfig(AbstractHandlerConfig inputConfig) {
        config = (DataDefinitionHandlerConfig) inputConfig;
    }

    public DataDefinitionHandlerConfig perModelConfig(Object inputObject) throws IOException {
                
        ScriptEngineManager manager = new ScriptEngineManager();
        manager.registerEngineName("velocity", new VelocityScriptEngineFactory());
        ScriptEngine scriptEngine = manager.getEngineByName("velocity");
        ScriptContext thisContext = scriptEngine.getContext();
        thisContext.setAttribute("cds", inputObject, ScriptContext.GLOBAL_SCOPE);
        scriptEngine.setContext(thisContext);
        
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(objectMapper.writeValueAsString(config));
        
        
        ObjectNode parentObjectNode = jsonThroughVelocity(scriptEngine, thisContext, (ObjectNode)rootNode);
       
        LOG.debug("Processed Model Config JSON into: {}", objectMapper.writeValueAsString(parentObjectNode));
        
        DataDefinitionHandlerConfig myConfig = objectMapper.readValue(objectMapper.writeValueAsString(parentObjectNode), DataDefinitionHandlerConfig.class);
        
        /**
         * Stuff field's into additional values field for direct access
         */
        for(Field declaredField : inputObject.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            try {
                if(!myConfig.additionalAttributes.containsKey(declaredField.getName())) {
                        LOG.debug("Stuffing {} into additional attributes", declaredField.getName());                        
                        myConfig.additionalAttributes.put(declaredField.getName(), declaredField.get(inputObject));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                LOG.debug("Silently ignoring inability to read {}",  declaredField.getName());
            }
        }
        
        return myConfig;
        
    }
    
    private ObjectNode jsonThroughVelocity(ScriptEngine inputEngine, ScriptContext inputContext, ObjectNode rootNode) {
        ObjectNode parentObjectNode = (ObjectNode) rootNode;
        Iterator<Map.Entry<String,JsonNode>> fields = rootNode.fields();
        
        while (fields.hasNext()) {
            Map.Entry<String,JsonNode> field = fields.next();
            StringWriter instanceConfigString = new StringWriter();
            inputContext.setWriter(instanceConfigString);

            try {
                if(field.getValue().isValueNode()) {
                    inputEngine.eval(field.getValue().asText());
                    parentObjectNode.put(field.getKey(), instanceConfigString.toString());
                    instanceConfigString.flush();
                } else {
                    parentObjectNode.replace(field.getKey(), jsonThroughVelocity(inputEngine, inputContext, (ObjectNode) field.getValue()));
                }
            } catch (ScriptException e) {
                LOG.error("Encountered a script rendering error while doing per model config on: {}", field.getValue().asText());
            }
        }
        
        return parentObjectNode;

    }

    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException {
        List<DataDefinitionModel> dataDefinitions = collectDataDefinitions();
        for (DataDefinitionModel oneModel : dataDefinitions) {
            // We reparse the supplied handler config in the context of this particular data definition model
            DataDefinitionHandlerConfig modelConfig = perModelConfig(oneModel);

            VelocityFile oneFile = new VelocityFile(modelConfig.fileName,
                    String.format("%s/%s/%s", options.getOutputPath(), modelConfig.baseDirectory, modelConfig.filePath), modelConfig.templateName,
                    modelConfig, oneModel);
            velocityHelper.addFile(oneFile);
        }

    }

}
