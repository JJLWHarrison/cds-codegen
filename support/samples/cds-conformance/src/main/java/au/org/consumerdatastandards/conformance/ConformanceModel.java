package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.ResponseCode;

import java.util.HashMap;
import java.util.Map;

public class ConformanceModel {

    private Map<String, Map<ResponseCode, EndpointResponse>> responseMap = new HashMap<>();

    public void add(EndpointModel endpointModel) {
        String operationId = endpointModel.getEndpoint().operationId();
        for(EndpointResponse response : endpointModel.getEndpoint().responses()){
            responseMap.computeIfAbsent(operationId, k -> new HashMap<>());
            responseMap.get(operationId).put(response.responseCode(), response);
        }
    }

    public EndpointResponse getResponse(String operationId, ResponseCode responseCode) {
        return responseMap.get(operationId).get(responseCode);
    }
}
