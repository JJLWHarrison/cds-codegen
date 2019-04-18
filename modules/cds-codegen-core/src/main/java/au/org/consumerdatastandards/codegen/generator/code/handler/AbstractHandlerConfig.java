package au.org.consumerdatastandards.codegen.generator.code.handler;

import java.lang.reflect.Field;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition.DataDefinitionHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.code.handler.section.SectionHandlerConfig;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
    @Type(value = DataDefinitionHandlerConfig.class, name = "DataDefinitionHandler"),
    @Type(value = SectionHandlerConfig.class, name = "SectionHandler") 
})
public abstract class AbstractHandlerConfig {
    public String endpointType;
    public String baseDirectory;
    public Map<String, Object> additionalAttributes;

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

    public Map<String, Object> getAdditionalAttributes() {
        return additionalAttributes;
    }
}
