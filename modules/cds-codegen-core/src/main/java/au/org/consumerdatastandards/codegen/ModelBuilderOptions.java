package au.org.consumerdatastandards.codegen;

import java.util.*;

public class ModelBuilderOptions {

    private Set<String> includedSections = new LinkedHashSet<>();

    private Set<String> excludedSections = new LinkedHashSet<>();

    public ModelBuilderOptions includeSections(String... sectionNames) {
        includedSections.addAll(Arrays.asList(sectionNames));
        return this;
    }

    public ModelBuilderOptions excludeSections(String... sectionNames) {
        excludedSections.addAll(Arrays.asList(sectionNames));
        return this;
    }

    public boolean isSectionIncluded(String sectionName) {
        return includedSections.isEmpty() && excludedSections.isEmpty()
            || includedSections.contains(sectionName)
            || !excludedSections.isEmpty() && !excludedSections.contains(sectionName);
    }
}
