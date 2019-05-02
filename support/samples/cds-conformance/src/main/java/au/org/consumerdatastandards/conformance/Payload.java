package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.support.EndpointResponse;

public class Payload {

    private PayloadType payloadType;

    private EndpointModel endpointModel;

    private EndpointResponse endpointResponse;

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    public EndpointModel getEndpointModel() {
        return endpointModel;
    }

    public void setEndpointModel(EndpointModel endpointModel) {
        this.endpointModel = endpointModel;
    }

    public EndpointResponse getEndpointResponse() {
        return endpointResponse;
    }

    public void setEndpointResponse(EndpointResponse endpointResponse) {
        this.endpointResponse = endpointResponse;
    }

    public String getDescription() {
        // TODO add endpoint / response info
        return payloadType.toString();
    }
}
