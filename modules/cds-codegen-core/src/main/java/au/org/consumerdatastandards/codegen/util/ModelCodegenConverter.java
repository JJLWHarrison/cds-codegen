package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition.DataDefinitionHandler;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.data.DataDefinition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModelCodegenConverter {
    
    private static final Logger LOG = LogManager.getLogger(ModelCodegenConverter.class);


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

        if (!response.content().equals(Void.class)) {
            processDataDefinition(codegenModel, response.content());
        }
    }

    private static void processDataDefinition(CodegenModel codegenModel, Class<?> dataDefinition) {
        LOG.debug("Processing data definition with name: {}", dataDefinition.getName());
        if (!codegenModel.containsDataDefinition(dataDefinition)) {
            codegenModel.addDataDefinition(dataDefinition);
        
            if (dataDefinition.isAnnotationPresent(DataDefinition.class)) {
                processDataDefinition(codegenModel, dataDefinition);
            }
            
            for(Field thisField : dataDefinition.getDeclaredFields()) {
                if(thisField.getType().isAnnotationPresent(DataDefinition.class)) {
                    processDataDefinition(codegenModel, thisField.getType());
                }
                if(thisField.getType().isAssignableFrom(List.class)) {
                    LOG.debug("Got an array field here: {}",  thisField.getType());
                    
/**                    try {
                        thisField.setAccessible(true);
                        Object[] arrayList = (Object[])thisField.get(dataDefinition);
                        for(Object o : arrayList) {
                            processDataDefinition(codegenModel, o.getClass());
                        }
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        LOG.debug("Silently ignoring inability to read {}", thisField.getName());
                    }
   */                 
                }
            }
        }
    }
}
