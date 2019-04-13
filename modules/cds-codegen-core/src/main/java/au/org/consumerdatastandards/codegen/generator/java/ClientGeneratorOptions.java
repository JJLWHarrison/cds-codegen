package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.Options;
import com.beust.jcommander.Parameter;

public class ClientGeneratorOptions extends Options {

    @Parameter(names = {"--template", "-t"}, description = "Velocity templates folder")
    private String templateName;
    
    @Parameter(names = {"--output-path", "-o"}, description = "Generation output path")
    private String outputPath = "./cds-generated";

    public String getTemplateName() {
        return templateName;
    }

    public String getOutputPath() {
        return outputPath;
    }    
}
