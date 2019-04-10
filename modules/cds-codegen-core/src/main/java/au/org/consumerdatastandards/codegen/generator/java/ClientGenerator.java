package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.Generator;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.model.APIModel;

public class ClientGenerator implements Generator {

    @Override
    public void generate(APIModel apiModel, Options cliModel) {

    }

    @Override
    public ClientGeneratorOptions commandOptions() {
        return new ClientGeneratorOptions();
    }

}
