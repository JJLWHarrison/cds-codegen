package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

public class TemplateTest {

    public static void main(String[] args) {
        ModelBuilder modelBuilder = new ModelBuilder();
        APIModel apiModel = modelBuilder.build();
        Swagger swagger = ModelSwaggerConverter.convert(apiModel);
        Json.prettyPrint(swagger);
    }
}
