package au.org.consumerdatastandards.codegen.generator.code;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.velocity.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.velocity.VelocityHelperJava;
import au.org.consumerdatastandards.codegen.generator.velocity.model.CDSAnnotation;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelCodegenConverter;

public class CodeGenerator extends AbstractGenerator<CodeGeneratorOptions> {

    public CodeGenerator(APIModel apiModel) {
        super(apiModel);
    }

    @Override
    public void generate() throws Exception {

        CodegenModel codegenModel = ModelCodegenConverter.convert(apiModel);
        generate(codegenModel);
    }

    public void generate(CodegenModel codegenModel) throws Exception {

        /**
         * Ideally we'd wrap this in the json config as well so that we could support other types
         * with variable templates
         */
        VelocityHelper velocityHelper = new VelocityHelperJava(options.getOutputPath());
        /**
         * @fyang1024: I'm thinking we can read a json config file and push sets of config through CDSAnnotation variations.
         *             Ideally CDSAnnotation would be retired and the json file would specify the Annotation type
         *             but this requires recursive descent through the whole model....
         *
         *             Another potential helper is a specific class matcher
         */
        for (Class<?> oneClass : velocityHelper.getAnnotatedDefinitions(codegenModel, CDSAnnotation.DATA_DEFINITION)) {
            velocityHelper.addFile(velocityHelper.toVelocityFile(oneClass, "/java/model.vm", "src/gen"));
        }

        /**
         * We now have all velocity files ready for writing
         *
         * TODO: Add postProcessing hook to allow further modifications
         */
        velocityHelper.writeFiles();

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
         context.put("class", CodeGeneratorOptions.class);

         StringWriter writer = new StringWriter();
         t.merge(context, writer);
         System.out.println(writer.toString());*/

    }

    @Override
    public void print() throws Exception {
        // If print has been called we should be generating first
        generate();
        System.out.println("Client Generator output printer");
    }

    @Override
    protected CodeGeneratorOptions createOptions() {
        return new CodeGeneratorOptions();
    }
}