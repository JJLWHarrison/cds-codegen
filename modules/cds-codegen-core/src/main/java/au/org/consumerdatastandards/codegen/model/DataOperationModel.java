package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.DataAttributeMatcher;
import au.org.consumerdatastandards.support.DataOperationType;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class DataOperationModel {
    private DataOperationType operationType;
    String dataDefinition;
    List<DataOperationAttributeModel> attributeModels = new ArrayList<DataOperationAttributeModel>();
    
    public DataOperationModel(DataOperationType type, String dataDefinition) {
        this.operationType = type;
        this.dataDefinition = dataDefinition;
    }

    public DataOperationType getOperationType() {
        return operationType;
    }
    
    public void addAttributeModel(String requestParameter, boolean required, DataAttributeMatcher matchMethod) {
        attributeModels.add(new DataOperationAttributeModel(requestParameter, required, matchMethod));
    }

    public String getDataDefinition() {
        return dataDefinition;
    }
    
    public String getDataDefinitionCamelised() {
        return StringUtils.uncapitalize(dataDefinition);
    }

    public List<DataOperationAttributeModel> getAttributeModels() {
        return attributeModels;
    }
}
