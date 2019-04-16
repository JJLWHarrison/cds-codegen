package au.org.consumerdatastandards.codegen.generator.code.handler.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.code.CodeGenerator;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.openapi.SwaggerGeneratorOptions;

public class ModelHandler extends AbstractHandler<ModelHandlerConfig> {
    private static final Logger LOG = LogManager.getLogger(ModelHandler.class);


    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof ModelHandlerConfig;
    }

    @Override
    public void productOutput() {
        LOG.error("Started execution of ModelHandler");
        
    }

    @Override
    public void setConfig(AbstractHandlerConfig inputConfig) {
        config = (ModelHandlerConfig)inputConfig;
    }
    
 
}
