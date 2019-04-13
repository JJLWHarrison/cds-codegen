package au.org.consumerdatastandards.codegen.generator.velocity;

import java.util.HashSet;
import java.util.Set;

import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

public class JavaVelocityFileHelper extends DefaultVelocityFileHelper {
    public JavaVelocityFileHelper(String inputPath) {
        super(inputPath);
        packagePathSeparator = "/";
        classExtension = ".java";
    }
}
