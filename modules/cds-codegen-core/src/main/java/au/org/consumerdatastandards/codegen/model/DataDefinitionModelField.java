package au.org.consumerdatastandards.codegen.model;

import org.apache.commons.lang3.StringUtils;

public class DataDefinitionModelField {
    public String name;
    public String type;
    public String description;
    public boolean isRequired;
    public String validationPattern;
    public Number minValue;
    public Number maxValue;
    
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
        return isRequired;
    }
    public String getCapitalisedName() {
        return StringUtils.capitalize(name);
    }
    
    
}
