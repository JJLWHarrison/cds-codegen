package au.org.consumerdatastandards.conformance.util;

import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.conformance.ConformanceModel;

public class ModelConformanceConverter {

    public static ConformanceModel convert(APIModel apiModel) {
        ConformanceModel conformanceModel = new ConformanceModel();
        for (SectionModel sectionModel : apiModel.getSectionModels()) {
            for (EndpointModel endpointModel : sectionModel.getEndpointModels()) {
                conformanceModel.add(endpointModel);
            }
        }
        return conformanceModel;
    }
}
