package au.org.consumerdatastandards.codegen.generator.code.handler;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import au.org.consumerdatastandards.codegen.generator.code.handler.model.ModelHandlerConfig;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
    @Type(value = ModelHandlerConfig.class, name = "ModelHandler") 
})
public abstract class AbstractHandlerConfig {
    public String endpointType;
    public String baseDirectory;

}
