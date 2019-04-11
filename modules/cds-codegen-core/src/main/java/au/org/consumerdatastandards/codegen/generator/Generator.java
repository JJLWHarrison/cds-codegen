package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.model.APIModel;

public abstract class Generator {

    protected OptionsBase options;

    abstract public void generate(APIModel apiModel);

    public Class<? extends OptionsBase> getOptionsClass() {
        return null;
    }

    public void setOptions(OptionsBase options) {
        this.options = options;
    }
}
