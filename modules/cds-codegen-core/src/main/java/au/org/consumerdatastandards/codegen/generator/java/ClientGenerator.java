package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.Generator;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.model.APIModel;

public class ClientGenerator extends AbstractCodeGenerator {


    @Override
    public void generate(CodegenModel codegenModel) {
        //TODO implement me
    }

    @Override
    public Class getOptionsClass() {
        return ClientGeneratorOptions.class;
    }

    @Override
    public void print() {
        // If print has been called we should be generating first
        this.generate();
        System.out.println("Client Generator output printer");
    }

}
