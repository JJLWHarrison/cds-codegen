package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.data.DataDefinition;

import java.lang.reflect.Field;
import java.util.Set;

public class ModelCodegenConverter {

    public static CodegenModel convert(APIModel apiModel) {

        CodegenModel codegenModel = new CodegenModel();
        codegenModel.setSectionModels(apiModel.getSectionModels());
        processSections(codegenModel);
        return codegenModel;
    }

    private static void processSections(CodegenModel codegenModel) {

        for (SectionModel sectionModel : codegenModel.getSectionModels()) {
            processSection(codegenModel, sectionModel);
        }
    }

    private static void processSection(CodegenModel codegenModel, SectionModel sectionModel) {

        processEndpoints(codegenModel, sectionModel.getEndpointModels());
    }

    private static void processEndpoints(CodegenModel codegenModel, Set<EndpointModel> endpointModels) {

        for (EndpointModel endpointModel : endpointModels) {
            processEndpoint(codegenModel, endpointModel);
        }
    }

    private static void processEndpoint(CodegenModel codegenModel, EndpointModel endpointModel) {

        processResponses(codegenModel, endpointModel.getEndpoint().responses());
    }

    private static void processResponses(CodegenModel codegenModel, EndpointResponse[] responses) {

        for (EndpointResponse response : responses) {
            processResponse(codegenModel, response);
        }
    }

    private static void processResponse(CodegenModel codegenModel, EndpointResponse response) {

        if (response.content().equals(Void.class)) {
            codegenModel.addDataDefinition(response.content());
            processDataDefinition(codegenModel, response.content());
        }
    }

    private static void processDataDefinition(CodegenModel codegenModel, Class dataDefinition) {

        if (!codegenModel.containsDataDefinition(dataDefinition)) {
            Class parent = dataDefinition.getSuperclass();
            if (parent.isAnnotationPresent(DataDefinition.class)) {
                processDataDefinition(codegenModel, parent);
            }
            codegenModel.addDataDefinition(dataDefinition);
            dataDefinition.getDeclaredFields();

        }
    }

    private static void processFields(CodegenModel codegenModel, Field[] fields) {

        for (Field field : fields) {
            if (field.getType().isAnnotationPresent(DataDefinition.class)) {
                processDataDefinition(codegenModel, field.getType());
            }
        }
    }
}
