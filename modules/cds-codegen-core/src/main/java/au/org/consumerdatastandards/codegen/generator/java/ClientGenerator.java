package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.AbstractCodeGenerator;
import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.OptionsBase;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;

import java.io.StringWriter;

public class ClientGenerator extends AbstractCodeGenerator {


    @Override
    public void generate(CodegenModel codegenModel) {

        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("file.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate("/java/model.vm");
        ToolManager manager = new ToolManager();
        manager.setVelocityEngine(ve);
        ToolContext context = manager.createContext();
        context.put("class", ClientGeneratorOptions.class);

        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        System.out.println(writer.toString());
    }

    @Override
    public Class<? extends OptionsBase> getOptionsClass() {
        return ClientGeneratorOptions.class;
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
