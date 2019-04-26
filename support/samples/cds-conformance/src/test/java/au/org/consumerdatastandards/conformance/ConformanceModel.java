package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.ResponseCode;

import java.util.HashMap;
import java.util.Map;

public class ConformanceModel {

    private Map<String, EndpointModel> endpointModelMap = new HashMap<>();

    private Map<String, Map<ResponseCode, EndpointResponse>> responseMap = new HashMap<>();

    public void add(EndpointModel endpointModel) {
        String operationId = endpointModel.getEndpoint().operationId();
        endpointModelMap.put(operationId, endpointModel);
        for(EndpointResponse response : endpointModel.getEndpoint().responses()){
            if (responseMap.get(operationId) == null) {
                responseMap.put(operationId, new HashMap<>());
            }
            responseMap.get(operationId).put(response.responseCode(), response);
        }
    }


    public EndpointResponse getResponse(String operationId, ResponseCode responseCode) {
        return responseMap.get(operationId).get(responseCode);
    }
}
