package au.org.consumerdatastandards.codegen.cli;

import java.util.ArrayList;
import java.util.List;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Perform Code Generation Tasks")
public class BaseCommandLine {

    @Parameter(names= {"--generator", "-g"}, description = "Class name of cds-codegen generator", order = 1)
    private String generatorClassName = "au.org.consumerdatastandards.codegen.generator.SwaggerGenerator";

    @Parameter(names = {"--included", "-i"}, description = "Include Section", order = 2, variableArity = true)
    private List<String> includedSections = new ArrayList<>();
    
    @Parameter(names = {"--excluded", "-e"}, description = "Exclude Section", order = 3, variableArity = true)
    private List<String> excludedSections = new ArrayList<>();
    
    @Parameter(names = {"--help", "-?", "-h" }, help = true)
    private boolean help;
    
    public String getGeneratorClassName() {
        return generatorClassName;
    }

    public List<String> getIncludedSections() {
        return includedSections;
    }

    public List<String> getExcludedSections() {
        return excludedSections;
    }

    public boolean isHelp() {
        return help;
    }
}