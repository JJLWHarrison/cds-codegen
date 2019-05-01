package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.ParamModel;
import au.org.consumerdatastandards.codegen.util.ReflectionUtil;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.DataDefinition;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConformanceModel {

    private Map<String, Map<ResponseCode, EndpointResponse>> responseMap = new HashMap<>();
    private Map<Class<?>, Payload> payloadMap = new HashMap<>();
    private Set<Class<?>> processedClasses = new HashSet<>();

    public void add(EndpointModel endpointModel) {
        Set<ParamModel> bodyParams = endpointModel.getBodyParams();
        if (bodyParams != null && !bodyParams.isEmpty()) {
            processBodyParams(endpointModel, bodyParams);
        }
        String operationId = endpointModel.getEndpoint().operationId();
        for (EndpointResponse response : endpointModel.getEndpoint().responses()) {
            responseMap.computeIfAbsent(operationId, k -> new HashMap<>());
            responseMap.get(operationId).put(response.responseCode(), response);
            processResponseBody(endpointModel, response);
        }
    }

    private void processBodyParams(EndpointModel endpointModel, Set<ParamModel> bodyParams) {
        for (ParamModel bodyParam : bodyParams) {
            Payload payload = new Payload();
            payload.setPayloadType(PayloadType.REQUEST_BODY);
            payload.setEndpointModel(endpointModel);
            payloadMap.put(bodyParam.getParamDataType(), payload);
            processDataDefinition(endpointModel, bodyParam.getParamDataType());
        }
    }

    private void processResponseBody(EndpointModel endpointModel, EndpointResponse response) {
        if (!response.content().equals(Void.class)) {
            Payload payload = new Payload();
            payload.setPayloadType(PayloadType.RESPONSE_BODY);
            payload.setEndpointModel(endpointModel);
            payload.setEndpointResponse(response);
            payloadMap.put(response.content(), payload);
            processDataDefinition(endpointModel, response.content());
        }
    }

    private void processDataDefinition(EndpointModel endpointModel, Class<?> dataType) {
        if (!processedClasses.contains(dataType)) {
            for (Field field : FieldUtils.getAllFields(dataType)) {
                Class<?> fieldType = field.getType();
                if (fieldType.isAnnotationPresent(DataDefinition.class) && !fieldType.isEnum()) {
                    addPayload(endpointModel, fieldType);
                    processDataDefinition(endpointModel, fieldType);
                } else if (ReflectionUtil.isSetOrList(fieldType)) {
                    Class<?> itemType = ReflectionUtil.getItemType(fieldType, field.getGenericType());
                    if (itemType.isAnnotationPresent(DataDefinition.class) && !itemType.isEnum()) {
                        addPayload(endpointModel, itemType);
                        processDataDefinition(endpointModel, itemType);
                    }
                } else if (fieldType.isArray()
                    && fieldType.getComponentType().isAnnotationPresent(DataDefinition.class)
                    && !fieldType.getComponentType().isEnum()) {
                    addPayload(endpointModel, fieldType.getComponentType());
                    processDataDefinition(endpointModel, fieldType.getComponentType());
                }
            }
            DataDefinition dataDefinition = dataType.getAnnotation(DataDefinition.class);
            if (dataDefinition != null && dataDefinition.allOf().length > 0) {
                for (Class<?> clazz : dataDefinition.allOf()) {
                    processDataDefinition(endpointModel, clazz);
                }
            }
            processedClasses.add(dataType);
        }
    }

    private void addPayload(EndpointModel endpointModel, Class<?> dataType) {
        if (payloadMap.get(dataType) == null) {
            Payload payload = new Payload();
            payload.setPayloadType(PayloadType.EMBEDDED_DATA);
            payload.setEndpointModel(endpointModel);
            payloadMap.put(dataType, payload);
        }
    }

    public EndpointResponse getResponse(String operationId, ResponseCode responseCode) {
        return responseMap.get(operationId).get(responseCode);
    }
}
