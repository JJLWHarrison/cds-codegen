package au.org.consumerdatastandards.codegen.generator.code.handler.section;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.EndpointResponse;

public class SectionHandler extends AbstractHandler<SectionHandlerConfig> {
    private static final Logger LOG = LogManager.getLogger(SectionHandler.class);

    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof SectionHandlerConfig;
    }

    @Override
    public void setConfig(AbstractHandlerConfig inputConfig) {
        config = (SectionHandlerConfig) inputConfig;
    }

    @Override
    public Class<?> getAbstractHandlerConfigClass() {
        return SectionHandlerConfig.class;
    }
    
    public SectionModel postProcessSectionModel(SectionModel oneSection) {
        Set<EndpointModel> newEndpointModelSet = new HashSet<EndpointModel>();
        
        for(EndpointModel oneEndpoint : oneSection.getEndpointModels()) {
            // Perform type mapping on default response
            oneEndpoint.setDefaultResponse(targetConfig.getTypeMapping(oneEndpoint.getDefaultResponse()));
            
            // Rebuild set
            newEndpointModelSet.add(oneEndpoint);
        }
        
        oneSection.setEndpointModels(newEndpointModelSet);
        
        return oneSection;
            
    }
    
    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException {
       for (SectionModel oneSection : codegenModel.getSectionModels()) {
            // Post process this
            oneSection = postProcessSectionModel(oneSection);
            // We reparse the config with the section data
            SectionHandlerConfig modelConfig = perModelConfig(oneSection);
            LOG.debug("Writing file to {}/{}/{} with template {}", options.getOutputPath(), modelConfig.baseDirectory, modelConfig.filePath, modelConfig.templateFile);
            VelocityFile oneFile = new VelocityFile(modelConfig.fileName,
                    String.format("%s/%s/%s", options.getOutputPath(), modelConfig.baseDirectory, modelConfig.filePath),
                    modelConfig.templateFile, modelConfig, oneSection);
            velocityHelper.addFile(oneFile);
        }

    }

}
