package au.org.consumerdatastandards.codegen.generator.openapi;

import com.beust.jcommander.JCommander;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

public class SwaggerGenerator extends AbstractGenerator {
    
    SwaggerGeneratorOptions options;


    public SwaggerGenerator(APIModel newModel) {
        super(newModel);
    }

    public SwaggerGenerator() {

    }
    
    @Override
    public void generate() {
        generateSwagger();
    }
    
    public Swagger generateSwagger() {
        return ModelSwaggerConverter.convert(apiModel);
    }
    
    @Override
    public void print() {
        Json.prettyPrint(this.generateSwagger());
    }
    
    @Override
    public String toString() {
        return Json.pretty(this.generateSwagger());
    }
    
    @Override
    public void populateOptions(String[] commandLineArgs) {
        SwaggerGeneratorOptions generatorOptions = new SwaggerGeneratorOptions();
        @SuppressWarnings("unused")
        JCommander generatorCommander = JCommander.newBuilder().addObject(generatorOptions).build();
        this.options = generatorOptions;
    }
}
