package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.generator.java.ClientGenerator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import io.swagger.models.Swagger;

public abstract class Generator {

    protected OptionsBase options;
    protected APIModel apiModel;

    abstract public void generate();
    abstract public void print();

    public Class<? extends OptionsBase> getOptionsClass() {
        return null;
    }

    public void setOptions(OptionsBase options) {
        this.options = options;
    }
    
    public Generator(APIModel newModel) {
        this.apiModel = newModel;
    }
    
    public Generator() {
        
    }
    
    public void setModel(APIModel newModel) {
        this.apiModel = newModel;
    }

}
