package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.ParamLocation;

import java.util.*;

public class EndpointModel extends ModelBase implements Comparable<EndpointModel> {

    private Endpoint endpoint;

    private Set<ParamModel> paramModels = new TreeSet<>();

    private Map<ParamLocation, Set<ParamModel>> paramsByLocation = new HashMap<>();

    private String defaultResponseTypeName;

    private DataOperationModel dataOperationModel;
    
    private boolean isPaginated = false;

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
        paramsByLocation.computeIfAbsent(paramModel.getParam().in(), k -> new HashSet<>());
        paramsByLocation.get(paramModel.getParam().in()).add(paramModel);
    }

    @Override
    public int compareTo(EndpointModel endpointModel) {

        int result = endpoint.path().replaceAll("[\\{|\\}]", "").compareTo(endpointModel.endpoint.path().replaceAll("[\\{|\\}]", ""));
        if (result != 0) return result;
        return endpoint.requestMethod().name().compareTo(endpointModel.endpoint.requestMethod().name());
    }

    public Set<ParamModel> getHeadParams() {

        return paramsByLocation.get(ParamLocation.HEADER);
    }

    public Set<ParamModel> getBodyParams() {

        return paramsByLocation.get(ParamLocation.BODY);
    }

    public Set<ParamModel> getFormParams() {

        return paramsByLocation.get(ParamLocation.FORM);
    }

    public Set<ParamModel> getQueryParams() {

        return paramsByLocation.get(ParamLocation.QUERY);
    }

    public Set<ParamModel> getPathParams() {

        return paramsByLocation.get(ParamLocation.PATH);
    }

    public Set<ParamModel> getCookieParams() {

        return paramsByLocation.get(ParamLocation.COOKIE);
    }

    public void setDefaultResponse(String name) {
        defaultResponseTypeName = name;
    }
    
    public String getDefaultResponse() {
        return defaultResponseTypeName;
    }

    public DataOperationModel getDataOperationModel() {
        return this.dataOperationModel;
    }

    public void setDataOperationModel(DataOperationModel inputModel) {
        this.dataOperationModel = inputModel;
    }
    
    public boolean hasDataOperation() {
        return this.dataOperationModel != null ? true : false;
    }

}
