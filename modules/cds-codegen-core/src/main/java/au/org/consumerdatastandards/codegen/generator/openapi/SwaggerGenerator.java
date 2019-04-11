package au.org.consumerdatastandards.codegen.generator.openapi;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

public class SwaggerGenerator extends AbstractGenerator {


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
