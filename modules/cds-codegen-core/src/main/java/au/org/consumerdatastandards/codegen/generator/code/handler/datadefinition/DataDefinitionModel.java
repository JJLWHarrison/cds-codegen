package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import java.util.ArrayList;
import java.util.List;

public class DataDefinitionModel {
    public String definitionName;
    public List<DataDefinitionModelField> fieldList = new ArrayList<DataDefinitionModelField>();
    public String packageName;
    public String extendsOn;
    public String definitionDescription;
    
    public String getDefinitionName() {
        return definitionName;
    }
    public List<DataDefinitionModelField> getFieldList() {
        return fieldList;
    }
    public String getPackageName() {
        return packageName;
    }
    
    public String getDefinitionDescription() {
        return definitionDescription;
    }
    
}
