package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Section;

import java.util.Set;
import java.util.TreeSet;

public class SectionModel extends ModelBase implements Comparable<SectionModel> {

    private final String name;

    private final String[] tags;

    private Set<EndpointModel> endpointModels = new TreeSet<>();

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

    public Set<EndpointModel> getEndpointModels() {

        return endpointModels;
    }

    public void add(EndpointModel endpointModel) {

        endpointModels.add(endpointModel);
    }

    @Override
    public int compareTo(SectionModel sectionModel) {

        return name.compareTo(sectionModel.name);
    }
}
