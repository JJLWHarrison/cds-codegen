package au.org.consumerdatastandards.codegen.generator.velocity;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.velocity.model.CDSAnnotation;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;

public class VelocityHelperJava extends VelocityHelperCDSAnnotation {
    public VelocityHelperJava(String inputPath) {
        super(inputPath);
        packagePathSeparator = "/";
        classExtension = ".java";
    }
    
}
