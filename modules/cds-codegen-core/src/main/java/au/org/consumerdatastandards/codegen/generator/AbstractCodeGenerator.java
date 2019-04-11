package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelCodegenConverter;

public abstract class AbstractCodeGenerator extends AbstractGenerator {

    public void generate(APIModel apiModel) {

        CodegenModel codegenModel = ModelCodegenConverter.convert(apiModel);
        generate(codegenModel);
    }

    abstract public void generate(CodegenModel codegenModel);
}
