package au.org.consumerdatastandards.codegen.generator.code;

import java.util.ArrayList;
import java.util.List;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class TargetConfigModel {
    
    List<AbstractHandlerConfig> handlers = new ArrayList<AbstractHandlerConfig>();

    public List<AbstractHandlerConfig> getHandlers() {
        return handlers;
    }

}
