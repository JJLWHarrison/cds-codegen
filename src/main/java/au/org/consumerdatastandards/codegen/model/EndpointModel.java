package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Endpoint;

import java.util.ArrayList;
import java.util.List;

public class EndpointModel {

    private Endpoint endpoint;

    private List<ParamModel> paramModels;

    public EndpointModel(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public List<ParamModel> getParamModels() {
        return paramModels;
    }

    public void addParamModel(ParamModel paramModel) {
        if (paramModels == null) {
            paramModels = new ArrayList<>();
        }
        paramModels.add(paramModel);
    }
}
