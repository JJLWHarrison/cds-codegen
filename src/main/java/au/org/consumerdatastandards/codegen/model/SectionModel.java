package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.Section;

import java.util.List;

public class SectionModel {

    private final String name;

    private final String[] tags;

    private List<Endpoint> endpoints;

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

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }
}
