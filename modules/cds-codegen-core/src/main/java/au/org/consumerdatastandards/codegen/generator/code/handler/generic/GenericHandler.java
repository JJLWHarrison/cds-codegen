package au.org.consumerdatastandards.codegen.generator.code.handler.generic;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.shaded.commons.io.FilenameUtils;

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
        GenericHandlerConfig modelConfig = perModelConfig(config);

        for(Entry<String, String> entry : modelConfig.getFileMapping().entrySet()) {
            LOG.debug("Writing file to {}/{}/{} with template {}", options.getOutputPath(), config.baseDirectory, entry.getValue(), entry.getKey());
            
            VelocityFile oneFile = new VelocityFile(FilenameUtils.getName(entry.getValue()),
                    FilenameUtils.normalize(FilenameUtils.getFullPath(String.format("%s/%s/%s", options.getOutputPath(), config.baseDirectory, entry.getValue()))),
                    entry.getKey(), modelConfig, codegenModel);
            velocityHelper.addFile(oneFile);            
        }
    }

}
