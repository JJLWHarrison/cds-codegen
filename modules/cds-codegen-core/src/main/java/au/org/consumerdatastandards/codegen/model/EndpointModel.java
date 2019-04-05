package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EndpointModel extends ModelBase implements Comparable<EndpointModel> {

    private Endpoint endpoint;

    private Set<ParamModel> paramModels = new TreeSet<>();

    public EndpointModel(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public Set<ParamModel> getParamModels() {
        return paramModels;
    }

    public void addParamModel(ParamModel paramModel) {

        paramModels.add(paramModel);
    }

    @Override
    public int compareTo(EndpointModel endpointModel) {

        int result = endpoint.path().replaceAll("[\\{|\\}]", "").compareTo(endpointModel.endpoint.path().replaceAll("[\\{|\\}]", ""));
        if (result != 0) return result;
        return endpoint.requestMethod().name().compareTo(endpointModel.endpoint.requestMethod().name());
    }
}
