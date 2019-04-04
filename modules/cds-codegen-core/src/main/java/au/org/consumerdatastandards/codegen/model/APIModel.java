package au.org.consumerdatastandards.codegen.model;

import java.util.List;

public class APIModel extends ModelBase {

    private List<SectionModel> sectionModels;

    public List<SectionModel> getSectionModels() {
        return sectionModels;
    }

    public void setSectionModels(List<SectionModel> sectionModels) {
        this.sectionModels = sectionModels;
    }
}
