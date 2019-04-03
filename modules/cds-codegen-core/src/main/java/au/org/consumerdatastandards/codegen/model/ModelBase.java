package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.codegen.util.CustomAttributesUtil;
import au.org.consumerdatastandards.support.data.CustomAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModelBase {

    protected List<CustomAttribute> attributes = new ArrayList<>();

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
