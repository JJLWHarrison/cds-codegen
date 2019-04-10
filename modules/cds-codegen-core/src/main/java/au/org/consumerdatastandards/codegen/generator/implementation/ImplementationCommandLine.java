package au.org.consumerdatastandards.codegen.generator.implementation;

import com.beust.jcommander.Parameter;
import au.org.consumerdatastandards.codegen.cli.BaseCommandLine;

public class ImplementationCommandLine extends BaseCommandLine {
    @Parameter(names = {"--template", "-t"}, description = "Template to generate")
    private String templateName;
}
