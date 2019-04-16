package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.code.CodeGenerator;
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
        for(Class<?> definitionClass : codegenModel.getDataDefinitions()) {
            DataDefinitionModel oneDataDefinition = new DataDefinitionModel();
            oneDataDefinition.name = definitionClass.getSimpleName();
            Field[] definitionFields = definitionClass.getDeclaredFields();
            for(Field oneField : definitionFields) {
                oneField.setAccessible(true);
                DataDefinitionModelField oneModelField = new DataDefinitionModelField();
                oneModelField.name = oneField.getName();
                oneModelField.type = oneField.getType().getSimpleName();
                oneDataDefinition.fields.add(oneModelField);
            }
            
            dataDefinitions.add(oneDataDefinition);
        }
        return dataDefinitions;
    }

    @Override
    public void setConfig(AbstractHandlerConfig inputConfig) {
        config = (DataDefinitionHandlerConfig)inputConfig;
    }
    
    public String renderConfig(String inputValue, Object inputObject) {
        VelocityEngine ve = new VelocityEngine();
        VelocityContext vc = new VelocityContext();
        //vc.put("config", o);
        return inputValue;
        
        
        //Template t = ve.getTemplate(oneFile.getVelocityTemplate());
    }

    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) {
        List<DataDefinitionModel> dataDefinitions = collectDataDefinitions();
        for(DataDefinitionModel oneModel : dataDefinitions) {
            //VelocityFile oneFile = new VelocityFile();
            //oneFile.setVelocityTemplate(config.templateName);
        }

        
    }
    
 
}
