package au.org.consumerdatastandards.codegen.generator;

import com.beust.jcommander.Parameter;

public class OptionsBase {

    @Parameter(names = {"--help", "-?", "-h" }, help = true)
    protected boolean help;

    public boolean isHelp() {
        return help;
    }
}
