package au.org.consumerdatastandards.codegen;

import java.lang.reflect.InvocationTargetException;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;
import com.beust.jcommander.ParameterException;

import au.org.consumerdatastandards.codegen.cli.BaseCommandLine;
import au.org.consumerdatastandards.codegen.generator.GeneratorInterface;
import au.org.consumerdatastandards.codegen.model.APIModel;

public class CodegenCLI {

    public static void main(String[] args) {
        BaseCommandLine bootstrapCliModel = new BaseCommandLine();
        JCommander bootstrapCli = JCommander.newBuilder().addObject(bootstrapCliModel).build();
        bootstrapCli.parseWithoutValidation(args);

        try {

            BaseCommandLine cliModel = new BaseCommandLine();
            
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
                getGenerator(cliModel).generate(apiModel, cliModel);
            }

        } catch (ParameterException e) {
            System.out.println(String.format("ERROR: %s \n", e.getMessage()));
            bootstrapCli.usage();
        }
    }

    private static GeneratorInterface getGenerator(BaseCommandLine cliModel) {

        try {
            if (cliModel.getGeneratorClassName() != null) {
                Class<? extends GeneratorInterface> targetGenerator = (Class<? extends GeneratorInterface>) Class
                        .forName(cliModel.getGeneratorClassName());
                return targetGenerator.getConstructor().newInstance();
            } else {
                throw new ParameterException("You must supply a generator name");
            }
        } catch (ClassNotFoundException e) {
            throw new ParameterException(
                    String.format("The specified generator of \"%s\" is not found", cliModel.getGeneratorClassName()));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new ParameterException(String.format("Unable to instantiate requested class of %s due to: %s",
                    cliModel.getGeneratorClassName(), e.getMessage()));
        }
    }

}
