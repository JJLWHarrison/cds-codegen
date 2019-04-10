package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.model.APIModel;

public interface Generator {

    void generate(APIModel apiModel, Options cliModel);

    Object commandOptions();
}
