package au.org.consumerdatastandards.codegen.generator.velocity.model;

import java.util.Arrays;

public class VelocityFile {
    
    String name;
    String path;
    String velocityTemplate;
    Class<?> fileClass;
    
    public VelocityFile(String inputFilename, String inputPath, String inputVelocityTemplate, Class<?> oneClass) {
        this.name = inputFilename;
        this.path = inputPath;
        this.velocityTemplate = inputVelocityTemplate;
        this.fileClass = oneClass;
    }

    public String getFullPath() {
        return String.join("/", Arrays.asList(getPath(), getName()));
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getVelocityTemplate() {
        return velocityTemplate;
    }
    public void setVelocityTemplate(String velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }
    
    public void setFileClass(Class<?> inputClass) {
        this.fileClass = inputClass;
    }
    
    public Class<?> getFileClass() {
        return fileClass;
    }
    
    public String getPackageName() {
        return fileClass.getPackage().getName();
    }
}
