package au.org.consumerdatastandards.codegen.generator.implementation;

import com.beust.jcommander.Parameter;

public class ImplementationCommandLine {
    @Parameter(names = {"--template", "-t"}, description = "Template to generate")
    private String templateName;
}
