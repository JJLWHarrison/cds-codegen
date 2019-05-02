package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Section;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SectionModel extends ModelBase implements Comparable<SectionModel> {

    private final String name;

    private final String[] tags;
    private String interfaceName;
    private String packageName;

    private Set<EndpointModel> endpointModels = new TreeSet<>();

    public SectionModel(Section section) {

        this.name = section.name();
        this.tags = section.tags();
    }

    public String getName() {

        return name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String inputPackage) {
        this.packageName = inputPackage;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String inputName) {
        this.interfaceName = inputName;
    }

    public String[] getTags() {

        return tags;
    }

    public Set<EndpointModel> getEndpointModels() {

        return endpointModels;
    }

    public Set<EndpointModel> getEndpointModelsWithDataOperations() {
        Set<EndpointModel> allModels = new LinkedHashSet<>();
        for (EndpointModel thisEndpoint : endpointModels) {
            if (thisEndpoint.hasDataOperation()) {
                allModels.add(thisEndpoint);
            }
        }
        return allModels;
    }

    public void add(EndpointModel endpointModel) {

        endpointModels.add(endpointModel);
    }

    public void setEndpointModels(Set<EndpointModel> inputModels) {
        endpointModels = inputModels;
    }

    @Override
    public int compareTo(SectionModel sectionModel) {

        return name.compareTo(sectionModel.name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("class %s {\n", getClass()));

        for (Field oneField : getClass().getDeclaredFields()) {
            oneField.setAccessible(true);
            try {
                sb.append(String.format("    %s: %s\n", oneField.getName(), (oneField.get(Object.class) == null ? "null"
                        : oneField.get(Object.class).toString().replace("\n", "\n    "))));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // I guess we won't print it
                sb.append(String.format("    %s, [unreadable]\n", oneField.getName()));
            }
        }
        sb.append("}");
        return sb.toString();
    }

}
