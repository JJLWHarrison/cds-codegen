package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.generator.Generator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang.StringUtils;

public class CodegenCLI {

    public static void main(String[] args) {

        Options options = new Options();
        JCommander bootstrapCli = JCommander.newBuilder().addObject(options).build();
        bootstrapCli.parseWithoutValidation(args);

        try {
            Options cliModel = new Options();
            Builder cliBaseBuilder = JCommander.newBuilder();
            if(getGenerator(options.getGeneratorClassName()).commandOptions() != null) {
                cliBaseBuilder.addObject(getGenerator(options.getGeneratorClassName()).commandOptions());
            } else {
                cliBaseBuilder.addObject(cliModel);
            }
            
            JCommander cliBuilder = cliBaseBuilder.build();

            cliBuilder.setProgramName(CodegenCLI.class.getTypeName());
            cliBuilder.parse(args);

            ModelBuilder modelBuilder = new ModelBuilder(cliModel);
            APIModel apiModel = modelBuilder.build();

            if (options.isHelp()) {
                cliBuilder.usage();
                System.exit(0);
            }

            if (options.getGeneratorClassName() != null) {
                getGenerator(cliModel.getGeneratorClassName()).generate(apiModel, cliModel);
            }
        } catch (ParameterException e) {
            System.out.println(String.format("ERROR: %s \n", e.getMessage()));
            bootstrapCli.usage();
        }
    }

    private static Generator getGenerator(String generatorClassName) {

        if (StringUtils.isBlank(generatorClassName)) {
            throw new ParameterException("You must supply a generator name");
        }

        try {
            Class targetGenerator = Class.forName(generatorClassName);
            return (Generator) targetGenerator.newInstance();
        } catch (ClassNotFoundException e) {
            String message = String.format("The specified generator of \"%s\" is not found", generatorClassName);
            throw new ParameterException(message);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            String message = String.format("Unable to instantiate requested class %s due to: %s", generatorClassName, e.getMessage());
            throw new ParameterException(message);
        }
    }

}
