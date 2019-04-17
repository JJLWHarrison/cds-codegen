package au.org.consumerdatastandards.codegen.generator.code.handler;

import java.io.IOException;

import com.beust.jcommander.JCommander;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.code.CodeGeneratorOptions;
import au.org.consumerdatastandards.codegen.generator.code.TargetConfigModel;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition.DataDefinitionHandlerConfig;

public abstract class AbstractHandler<O extends AbstractHandlerConfig>  {
    protected O config;
    protected CodegenModel codegenModel;
    protected TargetConfigModel targetConfig;
    protected CodeGeneratorOptions options;
    abstract public boolean matchConfig(AbstractHandlerConfig inputConfig);
    abstract public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException;
    abstract public void setConfig(AbstractHandlerConfig inputConfig);
    
    public void setCodegenModel(CodegenModel inputCodegen) {
        codegenModel = inputCodegen;
    }
    
    public void setCodegenOptions(CodeGeneratorOptions inputOptions) {
        options = inputOptions;
    }
    public void setTargetConfig(TargetConfigModel inputConfig) {
        targetConfig = inputConfig;
    }
    
}