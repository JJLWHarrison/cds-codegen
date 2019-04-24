package au.org.consumerdatastandards.codegen.generator.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelCodegenConverter;

public class CodeGenerator extends AbstractGenerator<CodeGeneratorOptions> {
    
    private static final Logger LOG = LogManager.getLogger(CodeGenerator.class);
    private final static String BASE_PACKAGE = "au.org.consumerdatastandards";
    
    public CodeGenerator(APIModel apiModel) {
        super(apiModel);
    }

    @Override
    public void generate() throws Exception {
        CodegenModel codegenModel = ModelCodegenConverter.convert(apiModel);
        generate(codegenModel);
    }

    public void generate(CodegenModel codegenModel) throws Exception {
        
        LOG.debug("Loading config file from: {}", options.getTargetConfigFilePath());
        
        File configFile = new File(options.getTargetConfigFilePath());
        InputStream configFileStream;
        
        /**
         * If not an explicit path maybe it's somewhere in resource path
         */
        if(configFile.isFile()) {
            configFileStream = new FileInputStream(configFile);
            
        } else {
            configFileStream = getClass().getClassLoader().getResourceAsStream(options.getTargetConfigFilePath()); 
        }
        
        /**
         * Is it still not a file?
         */
        if(configFileStream == null) {
            LOG.error("Unable to locate target JSON configuration: {}", configFile.getPath());
            throw new Exception("Unable to open target JSON configuration file.");
        }
        
        /**
         * Try to render it
         */
        VelocityHelper velocityHelper = new VelocityHelper(options.getOutputPath());
        ObjectMapper objectMapper = new ObjectMapper();
        TargetConfigModel targetConfig = objectMapper.readValue(configFileStream, TargetConfigModel.class);
        
        for(AbstractHandlerConfig oneConfig : targetConfig.getHandlers()) {
            Reflections reflections = new Reflections(BASE_PACKAGE);
            @SuppressWarnings("rawtypes")
            Set<Class<? extends AbstractHandler>> handlerClasses = reflections.getSubTypesOf(AbstractHandler.class);
            
            for(@SuppressWarnings("rawtypes") Class<? extends AbstractHandler> oneHandler : handlerClasses) {
                if(oneHandler.newInstance().matchConfig(oneConfig)) {
                    AbstractHandler<?> myHandler = oneHandler.newInstance();
                    myHandler.setConfig(oneConfig);
                    myHandler.setTargetConfig(targetConfig);
                    myHandler.setCodegenModel(codegenModel);
                    myHandler.setCodegenOptions(options);
                    myHandler.populateVelocityFiles(velocityHelper);
                }
            }
        }
        
        /**
         * We now have all velocity files ready for writing
         *
         * TODO: Add postProcessing hook to allow further modifications
         */
        velocityHelper.writeFiles();
    }

    @Override
    public void print() throws Exception {
        // If print has been called we should be generating first
        generate();
        LOG.info("Code Generator output complete");
    }

    @Override
    protected CodeGeneratorOptions createOptions() {
        return new CodeGeneratorOptions();
    }
}
