package au.org.consumerdatastandards.codegen.generator.openapi;

import au.org.consumerdatastandards.codegen.generator.Options;
import com.beust.jcommander.Parameter;

public class SwaggerGeneratorOptions extends Options {

    @Parameter(names = {"--output-file", "-o"}, description = "Output file to place generated swagger")
    private String outputFile;
    
}
