package au.org.consumerdatastandards.codegen.generator.openapi;

import au.org.consumerdatastandards.codegen.generator.Generator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

public class SwaggerGenerator extends Generator {

    public SwaggerGenerator(APIModel newModel) {
        super(newModel);
    }
    
    public SwaggerGenerator() {

    }

    @Override
    public void generate() {
        generateSwagger();
    }
    
    private Swagger generateSwagger() {
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
   

}
