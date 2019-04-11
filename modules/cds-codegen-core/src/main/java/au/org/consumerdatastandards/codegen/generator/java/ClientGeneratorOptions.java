package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.OptionsBase;
import com.beust.jcommander.Parameter;

public class ClientGeneratorOptions extends OptionsBase {

    @Parameter(names = {"--template", "-t"}, description = "Velocity templates folder")
    private String templateName;
}
