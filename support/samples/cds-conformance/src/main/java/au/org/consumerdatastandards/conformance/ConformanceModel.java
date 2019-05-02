package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.ResponseCode;

import java.util.Map;
import java.util.TreeMap;

public class ConformanceModel {

    private Map<String, Map<ResponseCode, EndpointResponse>> responseMap;
    private Map<Class<?>, Payload> payloadMap;
    private Map<String, Class<?>> fieldsClassMap;
    private TreeMap<String, Class<?>> nameClassMap;

    public void setResponseMap(Map<String, Map<ResponseCode, EndpointResponse>> responseMap) {
        this.responseMap = responseMap;
    }

    public void setPayloadMap(Map<Class<?>, Payload> payloadMap) {
        this.payloadMap = payloadMap;
    }

    public void setFieldsClassMap(Map<String, Class<?>> fieldsClassMap) {
        this.fieldsClassMap = fieldsClassMap;
    }

    public void setNameClassMap(TreeMap<String, Class<?>> nameClassMap) {
        this.nameClassMap = nameClassMap;
    }

    public EndpointResponse getResponse(String operationId, ResponseCode responseCode) {
        return responseMap.get(operationId).get(responseCode);
    }

    public Class<?> getClassByName(String name) {
        return nameClassMap.get(name);
    }

    public Class<?> getClassByFields(String fields) {
        return fieldsClassMap.get(fields);
    }

    public Payload getPlayload(Class<?> clazz) {
        return payloadMap.get(clazz);
    }
}
