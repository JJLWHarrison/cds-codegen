package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.generator.java.ClientGeneratorOptions;
import au.org.consumerdatastandards.codegen.model.APIModel;

public abstract class AbstractGenerator {

    protected ClientGeneratorOptions options;
    protected APIModel apiModel;

    abstract public void generate() throws Exception;
    abstract public void print() throws Exception;
    abstract public void populateOptions(String[] commandLineArgs);
    
    public AbstractGenerator(APIModel newModel) {
        this.apiModel = newModel;
    }

    public AbstractGenerator() {

    }

    public Class<? extends OptionsBase> getOptionsClass() {
        return null;
    }

    public void setOptions(OptionsBase options) {
        this.options = (ClientGeneratorOptions) options;
    }
   
    public void setModel(APIModel newModel) {
        this.apiModel = newModel;
    }

}
