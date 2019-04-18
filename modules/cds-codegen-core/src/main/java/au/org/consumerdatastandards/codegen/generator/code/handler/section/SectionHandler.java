package au.org.consumerdatastandards.codegen.generator.code.handler.section;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

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
    
    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException {
        for (SectionModel oneSection : codegenModel.getSectionModels()) {
            // We reparse the supplied section
            SectionHandlerConfig modelConfig = perModelConfig(oneSection);

            VelocityFile oneFile = new VelocityFile(modelConfig.fileName,
                    String.format("%s/%s/%s", options.getOutputPath(), modelConfig.baseDirectory, modelConfig.filePath),
                    modelConfig.sectionTemplate, modelConfig, oneSection);
            velocityHelper.addFile(oneFile);
        }

    }

}
