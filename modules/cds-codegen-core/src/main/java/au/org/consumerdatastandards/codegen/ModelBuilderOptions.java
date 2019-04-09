package au.org.consumerdatastandards.codegen;

import java.util.*;

import au.org.consumerdatastandards.codegen.model.CLIModel;

public class ModelBuilderOptions {

    private Set<String> includedSections = new LinkedHashSet<>();

    private Set<String> excludedSections = new LinkedHashSet<>();

    public ModelBuilderOptions includedSections(Set<String> sectionNames) {
        includedSections = sectionNames;
        return this;
    }

    public ModelBuilderOptions excludedSections(Set<String> sectionNames) {
        excludedSections = sectionNames;
        return this;
    }

    public boolean isSectionIncluded(String sectionName) {
        return includedSections.isEmpty() && excludedSections.isEmpty()
            || includedSections.contains(sectionName)
            || !excludedSections.isEmpty() && !excludedSections.contains(sectionName);
    }
    
    public static ModelBuilderOptions factory(CLIModel inputModel) {
        return new ModelBuilderOptions().includedSections(inputModel.getIncludedSections()).excludedSections(inputModel.getExcludedSections());
    }
}
