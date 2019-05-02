package au.org.consumerdatastandards.codegen.generator.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class TargetConfigModel {
    
    @JsonProperty("handlers")
    List<AbstractHandlerConfig> handlers = new ArrayList<AbstractHandlerConfig>();
    
    @JsonProperty("typeMappings")
    Map<String,String> typeMappings = new HashMap<String,String>();
    
    @JsonProperty("globalVariables")
    Map<String,String> globalVariables = new HashMap<String,String>();

    public List<AbstractHandlerConfig> getHandlers() {
        return handlers;
    }
    
    public String getTypeMapping(String inputType, String inputValue) {
        return String.format(typeMappings.get(inputType), inputValue);
    }

    public String getTypeMapping(String inputType) {
        return typeMappings.get(inputType) != null ? typeMappings.get(inputType) : inputType;
    }
    
    public boolean hasTypeMapping(String simpleName) {
        return typeMappings.containsKey(simpleName);
    }

    public Map<String, String> getGlobalVariables() {
        return globalVariables;
    }

}
