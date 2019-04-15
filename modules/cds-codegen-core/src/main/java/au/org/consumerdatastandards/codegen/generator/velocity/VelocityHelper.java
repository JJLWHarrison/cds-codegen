package au.org.consumerdatastandards.codegen.generator.velocity;

import java.util.Set;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.velocity.model.CDSAnnotation;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

public interface VelocityHelper {

    Set<VelocityFile> getFiles();

    void addFile(VelocityFile inputVelocityFile);

    void clearFiles();

    VelocityFile toVelocityFile(Class<?> inputClass, String inputVelocityTemplate, String startPath);

    void writeFiles();

    Set<Class<?>> getAnnotatedDefinitions(CodegenModel codegenModel, CDSAnnotation dataDefinition) throws Exception;
}
