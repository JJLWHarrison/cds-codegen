package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.model.APIModel;

public abstract class AbstractGenerator {

    protected OptionsBase options;
    protected APIModel apiModel;

    abstract public void generate();
    abstract public void print();
    
    public AbstractGenerator(APIModel newModel) {
        this.apiModel = newModel;
    }

    public AbstractGenerator() {

    }

    public Class<? extends OptionsBase> getOptionsClass() {
        return null;
    }

    public void setOptions(OptionsBase options) {
        this.options = options;
    }

    public void setModel(APIModel newModel) {
        this.apiModel = newModel;
    }

}
