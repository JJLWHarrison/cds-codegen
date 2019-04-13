package au.org.consumerdatastandards.codegen.generator.velocity;

import java.util.Set;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.velocity.model.CDSAnnotation;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

public interface VelocityHelper {
    public Set<VelocityFile> getFiles();
    public void addFile(VelocityFile inputVelocityFile);
    public void clearFiles();
    public VelocityFile toVelocityFile(Class<?> inputClass, String inputVelocityTemplate, String startPath);
    public void writeFiles();
    public Set<Class<?>> getAnnotatedDefinitions(CodegenModel codegenModel, CDSAnnotation dataDefinition) throws Exception;
}
