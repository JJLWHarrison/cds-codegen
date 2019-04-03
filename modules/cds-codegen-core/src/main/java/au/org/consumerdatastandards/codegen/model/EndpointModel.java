package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Endpoint;

import java.util.ArrayList;
import java.util.List;

public class EndpointModel extends ModelBase {

    private Endpoint endpoint;

    private List<ParamModel> paramModels = new ArrayList<>();

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

        paramModels.add(paramModel);
    }
}
