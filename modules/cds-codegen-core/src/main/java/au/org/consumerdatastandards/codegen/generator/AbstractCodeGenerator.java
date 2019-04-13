package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.util.ModelCodegenConverter;

public abstract class AbstractCodeGenerator extends AbstractGenerator {

    @Override
    public void generate() throws Exception {

        CodegenModel codegenModel = ModelCodegenConverter.convert(apiModel);
        generate(codegenModel);
    }

    abstract public void generate(CodegenModel codegenModel) throws Exception;
}
