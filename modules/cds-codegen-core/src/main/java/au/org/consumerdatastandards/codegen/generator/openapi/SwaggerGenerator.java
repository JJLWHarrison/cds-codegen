package au.org.consumerdatastandards.codegen.generator.openapi;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

public class SwaggerGenerator extends AbstractGenerator {

    public void generate(APIModel apiModel) {
        Swagger swagger = ModelSwaggerConverter.convert(apiModel);
        Json.prettyPrint(swagger);
    }
}
