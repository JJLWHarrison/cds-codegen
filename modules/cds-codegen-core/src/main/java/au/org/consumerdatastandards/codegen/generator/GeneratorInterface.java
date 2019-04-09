package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.cli.BaseCommandLine;
import au.org.consumerdatastandards.codegen.model.APIModel;

public interface GeneratorInterface {
    public void generate(APIModel apiModel, BaseCommandLine cliModel);
    public Object commandOptions();
}
