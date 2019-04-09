package au.org.consumerdatastandards.codegen;

import java.util.*;

import au.org.consumerdatastandards.codegen.cli.BaseCommandLine;

public class ModelBuilderOptions {

    private List<String> includedSections = new ArrayList<String>();
    private List<String> excludedSections = new ArrayList<String>();

    public ModelBuilderOptions includedSections(List<String> list) {
        includedSections = list;
        return this;
    }

    public ModelBuilderOptions excludedSections(List<String> list) {
        excludedSections = list;
        return this;
    }

    public boolean isSectionIncluded(String sectionName) {
        return includedSections.isEmpty() && excludedSections.isEmpty()
            || includedSections.contains(sectionName)
            || !excludedSections.isEmpty() && !excludedSections.contains(sectionName);
    }
    
    public static ModelBuilderOptions factory(BaseCommandLine inputModel) {
        return new ModelBuilderOptions().includedSections(inputModel.getIncludedSections()).excludedSections(inputModel.getExcludedSections());
    }
}
