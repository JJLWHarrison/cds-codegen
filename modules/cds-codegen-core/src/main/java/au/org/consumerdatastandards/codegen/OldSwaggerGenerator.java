package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.generator.SwaggerGenerator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

import java.util.Arrays;
import org.apache.commons.cli.*;

public class OldSwaggerGenerator {

    public static void main(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption("i", "include", true, "Sections to include");
        options.addOption("x", "exclude", true, "Sections to exclude");
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("i") && cmd.hasOption("x")) {
            throw new Error("Either included sections or excluded sections can be specified, but not both");
        }

        ModelBuilderOptions modelBuilderOptions = new ModelBuilderOptions();
        if (cmd.hasOption("i")) {
            String[] includedSections = cmd.getOptionValue('i').split(",");
            modelBuilderOptions.includedSections(Arrays.asList(includedSections));
        } else if (cmd.hasOption("x")) {
            String[] excludedSections = cmd.getOptionValue('x').split(",");
            modelBuilderOptions.excludedSections(Arrays.asList(excludedSections));
        }

        ModelBuilder modelBuilder = new ModelBuilder(modelBuilderOptions);
        APIModel apiModel = modelBuilder.build();
        Swagger swagger = SwaggerGenerator.convert(apiModel);
        Json.prettyPrint(swagger);
    }
}
