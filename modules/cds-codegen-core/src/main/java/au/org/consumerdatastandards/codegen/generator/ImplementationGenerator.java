package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.cli.BaseCommandLine;
import au.org.consumerdatastandards.codegen.generator.implementation.ImplementationCommandLine;
import au.org.consumerdatastandards.codegen.model.APIModel;

public class ImplementationGenerator implements GeneratorInterface {

    @Override
    public void generate(APIModel apiModel, BaseCommandLine cliModel) {
        /**
         * Placeholder
         */
        
    }

    @Override
    public Object commandOptions() {
        return new ImplementationCommandLine();
    }

}
