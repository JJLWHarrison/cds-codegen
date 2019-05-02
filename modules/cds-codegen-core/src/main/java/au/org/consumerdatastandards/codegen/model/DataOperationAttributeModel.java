package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.DataAttributeMatcher;
import au.org.consumerdatastandards.support.DataOperationType;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.ParamLocation;

import java.util.*;

public class DataOperationAttributeModel {
    private String requestParameter;
    private boolean required;
    private DataAttributeMatcher matchMethod;
    
    public DataOperationAttributeModel(String requestParameter, boolean required, DataAttributeMatcher matchMethod) {
        this.requestParameter = requestParameter;
        this.required = required;
        this.matchMethod = matchMethod;
    }

    public String getRequestParameter() {
        return requestParameter;
    }

    public boolean isRequired() {
        return required;
    }

    public DataAttributeMatcher getMatchMethod() {
        return matchMethod;
    }
    
    
    
}
