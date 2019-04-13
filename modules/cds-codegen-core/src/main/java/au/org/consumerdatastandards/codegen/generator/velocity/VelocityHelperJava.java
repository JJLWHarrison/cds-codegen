package au.org.consumerdatastandards.codegen.generator.velocity;

public class VelocityHelperJava extends VelocityHelperCDSAnnotation {
    public VelocityHelperJava(String inputPath) {
        super(inputPath);
        packagePathSeparator = "/";
        classExtension = ".java";
    }
    
}
