package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.Generator;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.model.APIModel;

public class ClientGenerator extends Generator {

    @Override
    public void generate(APIModel apiModel) {

    }

    @Override
    public Class getOptionsClass() {
        return ClientGeneratorOptions.class;
    }
}
