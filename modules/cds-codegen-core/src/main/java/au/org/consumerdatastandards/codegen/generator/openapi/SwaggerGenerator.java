package au.org.consumerdatastandards.codegen.generator.openapi;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.shaded.commons.io.FilenameUtils;


import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.code.CodeGenerator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

public class SwaggerGenerator extends AbstractGenerator<SwaggerGeneratorOptions> {
    
    private static final Logger LOG = LogManager.getLogger(SwaggerGenerator.class);

        
    public SwaggerGenerator(APIModel newModel) {
        super(newModel);
    }

    @Override
    public void generate() {
        generateSwagger();
    }
    
    public Swagger generateSwagger() {
        return ModelSwaggerConverter.convert(apiModel);
    }
    
    public boolean writeSwagger(String outputFile) {
        try {
            Files.createDirectories(Paths.get(FilenameUtils.getPath(outputFile)));
            FileWriter outputFileWriter = new FileWriter(outputFile);
            outputFileWriter.write(Json.pretty(generateSwagger()));
            outputFileWriter.close();
        } catch (IOException e) {
            LOG.error("Unable to write file to {}: {}", outputFile, e.getMessage());
            return false;
        }
        return true;
    }
    
    @Override
    public void print() {
        if(options.getOutputFile() != null) {
            if(writeSwagger(options.getOutputFile())) {
                LOG.error("Successfully wrote swagger to {}", options.getOutputFile());
            } else {
                LOG.error("Unable to write swagger to {}", options.getOutputFile());
                System.exit(1);
            }
        } else {
            Json.prettyPrint(this.generateSwagger());
        }
            
    }
    
    @Override
    public String toString() {
        return Json.pretty(this.generateSwagger());
    }

    @Override
    protected SwaggerGeneratorOptions createOptions() {
        return new SwaggerGeneratorOptions();
    }
}
