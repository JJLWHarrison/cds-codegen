package au.org.consumerdatastandards.codegen.generator;

import java.util.HashSet;
import java.util.Set;

public class CodegenModel {

    private Set<Class> dataDefinitions = new HashSet<>();

    public void addDataDefinition(Class dataDefinition) {

        dataDefinitions.add(dataDefinition);
    }

    public boolean containsDataDefinition(Class dataDefinition) {

        return dataDefinitions.contains(dataDefinition);
    }
}
