package au.org.consumerdatastandards.codegen.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Perform Code Generation Tasks")
public class Options {

    @Parameter(names= {"--generator", "-g"}, description = "Class name of cds-codegen generator", order = 1)
    private String generatorClassName = "au.org.consumerdatastandards.codegen.generator.openapi.SwaggerGenerator";

    @Parameter(names = {"--included", "-i"}, description = "Include Section (comma separated)", order = 2)
    private String includedSectionsString;
    
    @Parameter(names = {"--excluded", "-e"}, description = "Exclude Section (comma separated)", order = 3)
    private String excludedSectionsString;
    
    protected List<String> includedSections = new ArrayList<>();
    protected List<String> excludedSections = new ArrayList<>();

    @Parameter(names = {"--help", "-?", "-h" }, help = true)
    private boolean help;

    public Options(List<String> includedInit, List<String> excludedInit) {
        this.excludedSections = excludedInit;
        this.includedSections = includedInit;
    }

    public Options() {
       // zer0
    }
    
    public void translateIncludeExcludes() {
        if(excludedSectionsString != null) {
            this.excludedSections = Arrays.asList(excludedSectionsString.split(","));
        }
        
        if(includedSectionsString != null) {
            this.includedSections = Arrays.asList(includedSectionsString.split(","));
        }
    }

    public String getGeneratorClassName() {
        return generatorClassName;
    }

    public boolean isSectionIncluded(String sectionName) {
        return includedSections.isEmpty() && excludedSections.isEmpty()
            || includedSections.contains(sectionName)
            || !excludedSections.isEmpty() && !excludedSections.contains(sectionName);
    }


    public boolean isHelp() {
        return help;
    }
}