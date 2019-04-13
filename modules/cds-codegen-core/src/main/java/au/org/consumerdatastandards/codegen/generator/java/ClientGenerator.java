package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.AbstractCodeGenerator;
import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.OptionsBase;
import au.org.consumerdatastandards.codegen.generator.velocity.JavaVelocityFileHelper;
import au.org.consumerdatastandards.codegen.generator.velocity.VelocityFileHelper;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;

import com.beust.jcommander.JCommander;

import java.io.StringWriter;
import java.util.Set;

public class ClientGenerator extends AbstractCodeGenerator {

    @Override
    public void generate(CodegenModel codegenModel) {

        /**
         * We should abstract this further into a model handler (Default+Java)
         */
        Set<Class<?>> allDataDefinitions = codegenModel.getDataDefinitions();
        VelocityFileHelper fileHelper = new JavaVelocityFileHelper(options.getOutputPath());

        for (Class<?> oneClass : allDataDefinitions) {
            fileHelper.addFile(fileHelper.toVelocityFile(oneClass, "/java/model.vm", "src/gen"));
        }
        
        /**
         * We now have all velocity files ready for writing
         * 
         * TODO: Add postProcessing hook to allow further modifications
         */
        fileHelper.writeFiles();

        /**

        for(VelocityFile oneVelocityFile : fileHelper.getFiles()) {
            System.out.println("Path: " + oneVelocityFile.getFullPath() + " Template: " + oneVelocityFile.getVelocityTemplate() + " Class: " + oneVelocityFile.getFileClass());
        }
        

        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("file.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate("/java/model.vm");
        ToolManager manager = new ToolManager();
        manager.setVelocityEngine(ve);
        ToolContext context = manager.createContext();
        context.put("class", ClientGeneratorOptions.class);

        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println(writer.toString());*/

    }

    @Override
    public Class<? extends OptionsBase> getOptionsClass() {
        return ClientGeneratorOptions.class;
    }

    @Override
    public void populateOptions(String[] commandLineArgs) {
        ClientGeneratorOptions generatorOptions = new ClientGeneratorOptions();
        @SuppressWarnings("unused")
        JCommander generatorCommander = JCommander.newBuilder().addObject(generatorOptions).build();
        this.options = generatorOptions;
    }

    @Override
    public void print() {
        // If print has been called we should be generating first
        this.generate();
        System.out.println("Client Generator output printer");
    }

    public static void main(String[] args) {
        new ClientGenerator().generate(null);
    }

}
