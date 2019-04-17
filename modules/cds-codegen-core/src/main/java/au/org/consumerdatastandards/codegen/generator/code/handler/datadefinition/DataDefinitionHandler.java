package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
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
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

public class DataDefinitionHandler extends AbstractHandler<DataDefinitionHandlerConfig> {
    private static final Logger LOG = LogManager.getLogger(DataDefinitionHandler.class);

    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof DataDefinitionHandlerConfig;
    }

    public List<DataDefinitionModel> collectDataDefinitions() {
        List<DataDefinitionModel> dataDefinitions = new ArrayList<DataDefinitionModel>();
        for (Class<?> definitionClass : codegenModel.getDataDefinitions()) {
            LOG.debug("Parsing data definition named: {}", definitionClass.getName());
            DataDefinitionModel oneDataDefinition = new DataDefinitionModel();
            oneDataDefinition.definitionName = definitionClass.getSimpleName();
            oneDataDefinition.packageName = definitionClass.getPackage().getName();
            
            for(Annotation oneAnnotation : definitionClass.getAnnotations()) {
                //LOG.debug("Parsing annotation called {}",  oneAnnotation.annotationType().toString());
                if(oneAnnotation.annotationType().equals(DataDefinition.class)) {
                    DataDefinition thisDefinition = (DataDefinition)oneAnnotation;
                    oneDataDefinition.definitionDescription = thisDefinition.description();
                    Class<?>[] allOfClasses = thisDefinition.allOf();
                    if(allOfClasses.length > 0) {
                        oneDataDefinition.extendsOn = allOfClasses[0].getSimpleName();
                    }
                    
                }
                
            }
            
            Field[] definitionFields = definitionClass.getDeclaredFields();
            for (Field oneField : definitionFields) {
                oneField.setAccessible(true);
                DataDefinitionModelField oneModelField = new DataDefinitionModelField();
                oneModelField.name = oneField.getName();
                if(oneField.getType().isAssignableFrom(List.class)) {
                    Class<?> innerType = (Class<?>)((ParameterizedType) oneField.getGenericType()).getActualTypeArguments()[0];
                    oneModelField.type = targetConfig.getTypeMapping("List",  innerType.getSimpleName());
                } else {
                    if(targetConfig.hasTypeMapping(oneField.getType().getSimpleName())) {
                        oneModelField.type = targetConfig.getTypeMapping(oneField.getType().getSimpleName(), null);
                    } else {
                        oneModelField.type = oneField.getType().getSimpleName();
                    }                    
                }
                
                for(Annotation oneAnnotation : oneField.getAnnotations()) {
                    //LOG.debug("Parsing annotation called {}",  oneAnnotation.annotationType().toString());
                    if(oneAnnotation.annotationType().equals(Property.class)) {
                        Property thisProperty = (Property)oneAnnotation;
                        oneModelField.description = thisProperty.description();
                        oneModelField.required = thisProperty.required();                        
                    }
                    
                }
                
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

    @Override
    public Class<?> getAbstractHandlerConfigClass() {
        return DataDefinitionHandlerConfig.class;
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
