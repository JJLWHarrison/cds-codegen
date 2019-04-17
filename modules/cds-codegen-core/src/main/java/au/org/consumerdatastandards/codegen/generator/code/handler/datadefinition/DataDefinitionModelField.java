package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import org.apache.commons.lang3.StringUtils;

public class DataDefinitionModelField {
    public String name;
    public String type;
    public String description;
    public boolean required;
    
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public boolean isRequired() {
        return required;
    }
    public String getCapitalisedName() {
        return StringUtils.capitalize(name);
    }
    
    
}
