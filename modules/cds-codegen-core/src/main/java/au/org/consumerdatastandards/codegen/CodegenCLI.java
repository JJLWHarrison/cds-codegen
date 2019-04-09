package au.org.consumerdatastandards.codegen;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.CLIModel;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

public class CodegenCLI {

    public static void main(String[] args) throws ParseException {
        
        /**
         * Use CLI Model to parse the command line
         */
        CLIModel cliModel = new CLIModel();
        cliModel.parseCommandLine(args);

        /**
         * Setup model builder and API model
         */
        ModelBuilderOptions modelBuilderOptions = ModelBuilderOptions.factory(cliModel);
        ModelBuilder modelBuilder = new ModelBuilder(modelBuilderOptions);
        APIModel apiModel = modelBuilder.build();
        
        
        
        Swagger swagger = ModelSwaggerConverter.convert(apiModel);
        Json.prettyPrint(swagger);
    }

}
