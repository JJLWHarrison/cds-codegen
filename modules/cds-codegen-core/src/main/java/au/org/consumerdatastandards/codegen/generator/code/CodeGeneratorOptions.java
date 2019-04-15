package au.org.consumerdatastandards.codegen.generator.code;

import au.org.consumerdatastandards.codegen.generator.Options;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Generate code based on templates")
public class CodeGeneratorOptions extends Options {

    @Parameter(names = {"--template", "-t"}, description = "templates folder")
    private String templateFolder;
    
    @Parameter(names = {"--output-path", "-o"}, description = "output path")
    private String outputPath = "./cds-generated";

    public String getTemplateFolder() {
        return templateFolder;
    }

    public String getOutputPath() {
        return outputPath;
    }    
}
