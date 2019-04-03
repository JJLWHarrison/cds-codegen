package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Section;

import java.util.List;

public class SectionModel extends ModelBase {

    private final String name;

    private final String[] tags;

    private List<EndpointModel> endpointModels;

    public SectionModel(Section section) {
        this.name = section.name();
        this.tags = section.tags();
    }

    public String getName() {
        return name;
    }

    public String[] getTags() {
        return tags;
    }

    public List<EndpointModel> getEndpointModels() {
        return endpointModels;
    }

    public void setEndpointModels(List<EndpointModel> endpointModels) {
        this.endpointModels = endpointModels;
    }
}
