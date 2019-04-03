package au.org.consumerdatastandards.codegen.model;

import java.util.List;

public class APIModel extends ModelBase {

    private List<SectionModel> sectionModels;

    private List<DataDefinitionModel> dataDefinitionModels;

    public List<SectionModel> getSectionModels() {
        return sectionModels;
    }

    public void setSectionModels(List<SectionModel> sectionModels) {
        this.sectionModels = sectionModels;
    }

    public List<DataDefinitionModel> getDataDefinitionModels() {
        return dataDefinitionModels;
    }

    public void setDataDefinitionModels(List<DataDefinitionModel> dataDefinitionModels) {
        this.dataDefinitionModels = dataDefinitionModels;
    }
}
