package au.org.consumerdatastandards.codegen.generator.code.handler;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.script.VelocityScriptEngineFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.code.CodeGeneratorOptions;
import au.org.consumerdatastandards.codegen.generator.code.TargetConfigModel;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition.DataDefinitionHandler;

public abstract class AbstractHandler<O extends AbstractHandlerConfig>  {
    protected O config;
    protected CodegenModel codegenModel;
    protected TargetConfigModel targetConfig;
    protected CodeGeneratorOptions options;
    abstract public boolean matchConfig(AbstractHandlerConfig inputConfig);
    abstract public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException;
    abstract public void setConfig(AbstractHandlerConfig inputConfig);
    
    private static final Logger LOG = LogManager.getLogger(DataDefinitionHandler.class);

    
    public void setCodegenModel(CodegenModel inputCodegen) {
        codegenModel = inputCodegen;
    }
    
    public void setCodegenOptions(CodeGeneratorOptions inputOptions) {
        options = inputOptions;
    }
    public void setTargetConfig(TargetConfigModel inputConfig) {
        targetConfig = inputConfig;
    }
    
    private ObjectNode jsonThroughVelocity(ScriptEngine inputEngine, ScriptContext inputContext, ObjectNode rootNode) {
        ObjectNode parentObjectNode = rootNode;
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
    
    public Class<?> getAbstractHandlerConfigClass() {
        return AbstractHandlerConfig.class;
    }
    
    public <C extends AbstractHandlerConfig> C perModelConfig(Object inputObject) throws IOException {
        
        ScriptEngineManager manager = new ScriptEngineManager();
        manager.registerEngineName("velocity", new VelocityScriptEngineFactory());
        ScriptEngine scriptEngine = manager.getEngineByName("velocity");
        ScriptContext thisContext = scriptEngine.getContext();
        thisContext.setAttribute("cds", inputObject, ScriptContext.GLOBAL_SCOPE);
        scriptEngine.setContext(thisContext);
        
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(objectMapper.writeValueAsString(config));
        
        /**
         * Stuff global variables into context so jsonThroughVelocity
         * can parse them.
         */
        for(Entry<String, String> oneEntry : targetConfig.getGlobalVariables().entrySet()) {
            thisContext.setAttribute(oneEntry.getKey(), oneEntry.getValue(), ScriptContext.GLOBAL_SCOPE);
        }
        
        
        ObjectNode parentObjectNode = jsonThroughVelocity(scriptEngine, thisContext, (ObjectNode)rootNode);
                       
        @SuppressWarnings("unchecked")
        C myConfig = (C) objectMapper.readValue(objectMapper.writeValueAsString(parentObjectNode), getAbstractHandlerConfigClass());
        
        /**
         * Stuff Global config into additionalAttributes for direct access,
         * VelocityHelper transfers this to be directly available
         */
        for(Entry<String, String> oneEntry : targetConfig.getGlobalVariables().entrySet()) {
            myConfig.additionalAttributes.put(oneEntry.getKey(), oneEntry.getValue());
        }
        
        /**
         * Stuff field's into additional values field for direct access
         */
        for(Field declaredField : inputObject.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            try {
                if(!myConfig.additionalAttributes.containsKey(declaredField.getName())) {
                        //LOG.debug("Stuffing {} into additional attributes", declaredField.getName());                        
                        myConfig.additionalAttributes.put(declaredField.getName(), declaredField.get(inputObject));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                LOG.warn("Silently ignoring inability to read {}",  declaredField.getName());
            }
        }
        
        return myConfig;
        
    }
    
}