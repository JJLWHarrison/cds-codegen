package au.org.consumerdatastandards.codegen.generator.code.handler.generic;

import java.io.IOException;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

public class GenericHandler extends AbstractHandler<GenericHandlerConfig> {
    private static final Logger LOG = LogManager.getLogger(GenericHandler.class);

    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof GenericHandlerConfig;
    }

    @Override
    public void setConfig(AbstractHandlerConfig inputConfig) {
        config = (GenericHandlerConfig) inputConfig;
    }

    @Override
    public Class<?> getAbstractHandlerConfigClass() {
        return GenericHandlerConfig.class;
    }
    
    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException {
        GenericHandlerConfig modelConfig = perModelConfig(codegenModel);

        for(Entry<String, String> entry : config.getFileMapping().entrySet()) {
            LOG.debug("Writing file to {}/{}/{} with template {}", options.getOutputPath(), config.baseDirectory, entry.getValue(), entry.getKey());
            VelocityFile oneFile = new VelocityFile(entry.getValue(),
                    String.format("%s/%s/%s", options.getOutputPath(), config.baseDirectory, entry.getValue()),
                    entry.getKey(), modelConfig, codegenModel);
            velocityHelper.addFile(oneFile);            
        }
    }

}
