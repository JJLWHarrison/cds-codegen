package au.org.consumerdatastandards.codegen.generator.java;

import com.beust.jcommander.Parameter;

public class ClientGeneratorOptions {

    @Parameter(names = {"--template", "-t"}, description = "Template to generate")
    private String templateName;
}
