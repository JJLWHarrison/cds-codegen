package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.cli.BaseCommandLine;
import au.org.consumerdatastandards.codegen.generator.GeneratorInterface;
import au.org.consumerdatastandards.codegen.model.APIModel;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang.StringUtils;

public class CodegenCLI {

    public static void main(String[] args) {

        BaseCommandLine bootstrapCliModel = new BaseCommandLine();
        JCommander bootstrapCli = JCommander.newBuilder().addObject(bootstrapCliModel).build();
        bootstrapCli.parseWithoutValidation(args);

        try {

            BaseCommandLine cliModel = new BaseCommandLine();
            
            Builder cliBaseBuilder = JCommander.newBuilder().addObject(cliModel);
            if(getGenerator(bootstrapCliModel.getGeneratorClassName()).commandOptions() != null) {
                cliBaseBuilder.addObject(getGenerator(bootstrapCliModel.getGeneratorClassName()).commandOptions());
            Builder cliBaseBuilder = JCommander.newBuilder();
            if(getGenerator(bootstrapCliModel).commandOptions() != null) {
                cliBaseBuilder.addObject(getGenerator(bootstrapCliModel).commandOptions());
            } else {
                cliBaseBuilder.addObject(cliModel);
            }
            
            JCommander cliBuilder = cliBaseBuilder.build();

            cliBuilder.setProgramName(CodegenCLI.class.getTypeName());
            cliBuilder.parse(args);

            ModelBuilderOptions modelBuilderOptions = ModelBuilderOptions.factory(cliModel);
            ModelBuilder modelBuilder = new ModelBuilder(modelBuilderOptions);
            APIModel apiModel = modelBuilder.build();

            if (bootstrapCliModel.isHelp()) {
                cliBuilder.usage();
                System.exit(0);
            }

            if (bootstrapCliModel.getGeneratorClassName() != null) {
                getGenerator(cliModel.getGeneratorClassName()).generate(apiModel, cliModel);
            }

        } catch (ParameterException e) {
            System.out.println(String.format("ERROR: %s \n", e.getMessage()));
            bootstrapCli.usage();
        }
    }

    private static GeneratorInterface getGenerator(String generatorClassName) {

        if (StringUtils.isBlank(generatorClassName)) {
            throw new ParameterException("You must supply a generator name");
        }
        try {
            Class targetGenerator = Class.forName(generatorClassName);
            return (GeneratorInterface) targetGenerator.newInstance();
        } catch (ClassNotFoundException e) {
            String message = String.format("The specified generator of \"%s\" is not found", generatorClassName);
            throw new ParameterException(message);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            String message = String.format("Unable to instantiate requested class %s due to: %s", generatorClassName, e.getMessage());
            throw new ParameterException(message);
        }
    }

}
