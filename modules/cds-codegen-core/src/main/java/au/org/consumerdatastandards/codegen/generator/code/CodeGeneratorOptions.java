package au.org.consumerdatastandards.codegen.generator.code;

import au.org.consumerdatastandards.codegen.generator.Options;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Generate code based on templates")
public class CodeGeneratorOptions extends Options {

    @Parameter(names = {"--target", "-t"}, description = "path to target config and templates (can be absolute or classpath reference)", required = true)
    private String targetPath;
    
    @Parameter(names = {"--output-path", "-o"}, description = "output path")
    private String outputPath = "./cds-generated";

    public String getTargetPath() {
        return targetPath;
    }
    
    public String getTargetConfigFilePath() {
        return String.format("%s/config.json", getTargetPath());
    }

    public String getOutputPath() {
        return outputPath;
    }    
}
