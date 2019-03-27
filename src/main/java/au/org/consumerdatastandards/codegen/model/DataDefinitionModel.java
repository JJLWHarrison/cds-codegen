package au.org.consumerdatastandards.codegen.model;

public class DataDefinitionModel {

    private final Class dataType;

    public DataDefinitionModel(Class dataType) {
        this.dataType = dataType;
    }

    public Class getDataType() {
        return dataType;
    }
}