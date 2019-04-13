package au.org.consumerdatastandards.codegen.generator.velocity;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.velocity.model.CDSAnnotation;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

public class VelocityHelperDefault implements VelocityHelper {

    public Set<VelocityFile> velocityFiles = new HashSet<VelocityFile>();
    public String basePath;
    public String packagePathSeparator;
    public String classExtension;

    @Override
    public Set<VelocityFile> getFiles() {
        return velocityFiles;
    }

    @Override
    public void addFile(VelocityFile inputVelocityFile) {
        velocityFiles.add(inputVelocityFile);
    }

    @Override
    public void clearFiles() {
        velocityFiles.clear();
    }

    private String classToFileName(String inputClassName) {
        inputClassName = inputClassName.substring(inputClassName.lastIndexOf('.') + 1).concat(this.classExtension);
        return inputClassName;
    }

    private String classToPath(String inputPackageName, String startPath) {
        return String.join("/", Arrays.asList(basePath, startPath, inputPackageName.replace(".", packagePathSeparator)));
    }

    public VelocityHelperDefault(String inputPath) {
        basePath = inputPath;
    }

    @Override
    public void writeFiles() {
        for (VelocityFile oneFile : velocityFiles) {
            try {
                Files.createDirectories(Paths.get(oneFile.getPath()));
                FileWriter outputFileWriter = new FileWriter(oneFile.getFullPath());
                
                /**
                 * Parse the template for this class
                 */
                VelocityEngine ve = new VelocityEngine();
                ve.setProperty("file.resource.loader.class", ClasspathResourceLoader.class.getName());
                ve.init();
                Template t = ve.getTemplate(oneFile.getVelocityTemplate());
                ToolManager manager = new ToolManager(true, true);
                manager.setVelocityEngine(ve);
                
                ToolContext context = manager.createContext();
                context.put("class", oneFile.getFileClass());
                // TODO: I can't figure out how to get the DisplayTool working...
                context.put("StringUtils", org.apache.commons.lang3.StringUtils.class);
                context.put("package", oneFile.getPackageName());
                t.merge(context, outputFileWriter);
                
                outputFileWriter.close();
                
                System.out.println("Wrote file: " + oneFile.getFullPath());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    @Override
    public VelocityFile toVelocityFile(Class<?> inputClass, String inputVelocityTemplate, String startPath) {
        return new VelocityFile(classToFileName(inputClass.getTypeName()),
                classToPath(inputClass.getPackage().getName(), startPath), inputVelocityTemplate, inputClass);
    }

    @Override
    public Set<Class<?>> getAnnotatedDefinitions(CodegenModel codegenModel, CDSAnnotation dataDefinition)
            throws Exception {
        return new HashSet<Class<?>>();
    }

}
