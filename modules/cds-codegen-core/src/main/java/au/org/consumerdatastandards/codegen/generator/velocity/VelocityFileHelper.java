package au.org.consumerdatastandards.codegen.generator.velocity;

import java.util.Set;

import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

public interface VelocityFileHelper {
    public Set<VelocityFile> getFiles();
    public void addFile(VelocityFile inputVelocityFile);
    public void clearFiles();
    public VelocityFile toVelocityFile(Class<?> inputClass, String inputVelocityTemplate, String startPath);
    public void writeFiles();
}
