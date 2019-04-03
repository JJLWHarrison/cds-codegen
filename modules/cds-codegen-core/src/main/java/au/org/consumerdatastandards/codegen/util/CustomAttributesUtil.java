package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.model.ModelBase;
import au.org.consumerdatastandards.support.data.CustomAttribute;
import au.org.consumerdatastandards.support.data.CustomAttributes;

import java.lang.reflect.AnnotatedElement;
import java.util.*;

public class CustomAttributesUtil {

    public static void addCustomAttributes(AnnotatedElement annotatedElement, ModelBase model) {

        CustomAttribute customAttribute = annotatedElement.getAnnotation(CustomAttribute.class);
        if (customAttribute != null) {
            model.add(customAttribute);
        }
        CustomAttributes customAttributes = annotatedElement.getAnnotation(CustomAttributes.class);
        if (customAttributes != null) {
            model.addAll(customAttributes.value());
        }
    }

    public static Map<String, Object> getGroupedAttributes(AnnotatedElement annotatedElement) {

        List<CustomAttribute> attributes = new ArrayList<>();
        CustomAttribute customAttribute = annotatedElement.getAnnotation(CustomAttribute.class);
        if (customAttribute != null) {
            attributes.add(customAttribute);
        }
        CustomAttributes customAttributes = annotatedElement.getAnnotation(CustomAttributes.class);
        if (customAttributes != null) {
            Collections.addAll(attributes, customAttributes.value());
        }

        return getGroupedAttributes(attributes);
    }

    public static Map<String, Object> getGroupedAttributes(List<CustomAttribute> attributes) {
        Map<String, Object> map = new LinkedHashMap<>();
        for (CustomAttribute attribute : attributes) {
            if (attribute.multiple()) {
                List<String> values = new ArrayList<>();
                if (map.get(attribute.name()) != null) {
                    values = (List<String>)map.get(attribute.name());
                }
                values.add(attribute.value());
                map.put(attribute.name(), values);
            } else {
                map.put(attribute.name(), attribute.value());
            }
        }
        return map;
    }

}
