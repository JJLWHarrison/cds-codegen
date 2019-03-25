package au.org.consumerdatastandards.codegen.model;

public class DataDefinitionModel {

    private Class dataType;

    public DataDefinitionModel(Class dataType) {
        this.dataType = dataType;
    }

    public Class getDataType() {
        return dataType;
    }

    public void setDataType(Class dataType) {
        this.dataType = dataType;
    }
}
