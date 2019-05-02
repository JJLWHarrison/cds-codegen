package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import java.util.LinkedHashSet;
import java.util.Set;

public class CodegenModel {

    private Set<SectionModel> sectionModels;
    private Set<Class<?>> dataDefinitions = new LinkedHashSet<>();

    public void setSectionModels(Set<SectionModel> sectionModels) {
        this.sectionModels = sectionModels;
    }
    
    public Set<Class<?>> getEndpointModels() {
        Set<Class<?>> allModels = new LinkedHashSet<>();
        for(SectionModel thisSection : getSectionModels()) {
            for(EndpointModel thisEndpoint : thisSection.getEndpointModels()) {
                allModels.add(thisEndpoint.getClass());
            }
        }
        return allModels;
    }

    public Set<SectionModel> getSectionModels() {
        return sectionModels;
    }

    public void addDataDefinition(Class<?> dataDefinition) {
        dataDefinitions.add(dataDefinition);
    }

    public boolean containsDataDefinition(Class<?> dataDefinition) {
        return dataDefinitions.contains(dataDefinition);
    }
    
    public Set<Class<?>> getDataDefinitions() {
        return dataDefinitions;
    }
}
