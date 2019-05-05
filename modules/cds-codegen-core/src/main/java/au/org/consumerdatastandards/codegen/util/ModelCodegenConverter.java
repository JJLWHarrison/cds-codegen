package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.ParamModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.data.DataDefinition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModelCodegenConverter {
    
    @SuppressWarnings("unused")
    private static final Logger LOG = LogManager.getLogger(ModelCodegenConverter.class);
    public static final Set<Class<?>> BASE_TYPES = getBaseTypes();


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
            //LOG.debug("Default response for {} currently set to {}", endpointModel.getEndpoint().operationId(), endpointModel.getDefaultResponse());
            processEndpoint(codegenModel, endpointModel);
        }
    }

    private static void processEndpoint(CodegenModel codegenModel, EndpointModel endpointModel) {
        processResponses(codegenModel, endpointModel.getEndpoint().responses());
        processParamModels(codegenModel, endpointModel.getParamModels());
    }
    
    public static void processParamModels(CodegenModel codegenModel, Set<ParamModel> paramModels) {
        // Parameters are data definitions too!
        for(ParamModel oneParam : paramModels) {
            processDataDefinition(codegenModel, oneParam.getParamDataType());
        }
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
        if (!BASE_TYPES.contains(dataDefinition) && !codegenModel.containsDataDefinition(dataDefinition)) {
            codegenModel.addDataDefinition(dataDefinition);
        
            if (dataDefinition.isAnnotationPresent(DataDefinition.class)) {
                processDataDefinition(codegenModel, dataDefinition);
            }
            
            if (dataDefinition.getSuperclass() != null) {
                processDataDefinition(codegenModel, dataDefinition.getSuperclass());
            }
            
            for(Field thisField : dataDefinition.getDeclaredFields()) {
                if(thisField.getType().isAnnotationPresent(DataDefinition.class)) {
                    processDataDefinition(codegenModel, thisField.getType());
                }
                if(thisField.getType().isAssignableFrom(List.class)) {
                    Class<?> innerType = (Class<?>)((ParameterizedType) thisField.getGenericType()).getActualTypeArguments()[0];
                    processDataDefinition(codegenModel, innerType);  
                }
            }
        }
    }
    
    private static Set<Class<?>> getBaseTypes()
    {
        Set<Class<?>> ret = new LinkedHashSet<Class<?>>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        ret.add(String.class);
        ret.add(Enum.class);
        ret.add(Object.class);
        return ret;
    }
}
