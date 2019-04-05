package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.codegen.util.CustomAttributesUtil;
import au.org.consumerdatastandards.support.data.CustomAttribute;

import java.util.*;

public class ModelBase {

    protected Set<CustomAttribute> attributes = new TreeSet<>(Comparator.comparing(attribute -> (attribute.name() + attribute.value())));

    public void add(CustomAttribute customAttribute) {

        attributes.add(customAttribute);
    }

    public void addAll(CustomAttribute[] customAttributes) {

        for (CustomAttribute customAttribute : customAttributes) {
            add(customAttribute);
        }
    }

    public Map<String, Object> getGroupedAttributes() {

        return CustomAttributesUtil.getGroupedAttributes(attributes);
    }
}
