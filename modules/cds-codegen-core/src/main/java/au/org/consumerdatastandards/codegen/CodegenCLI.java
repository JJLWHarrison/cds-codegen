package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.OptionsBase;
import au.org.consumerdatastandards.codegen.model.APIModel;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang3.StringUtils;

public class CodegenCLI {

    public static void main(String[] args) throws Exception {

        Options options = new Options();
        JCommander commander = JCommander.newBuilder().addObject(options).build();
        commander.setProgramName(CodegenCLI.class.getSimpleName());
        commander.parse(args);

        try {
            AbstractGenerator generator = getGenerator(options.getGeneratorClassName());
            Class<? extends OptionsBase> optionsClass = generator.getOptionsClass();
            if (optionsClass != null) {
                OptionsBase generatorOptions = optionsClass.newInstance();
                JCommander generatorCommander = JCommander.newBuilder().addObject(generatorOptions).build();
                generatorCommander.setProgramName(generator.getClass().getSimpleName());
                generatorCommander.parse(args);
                if (generatorOptions.isHelp()) {
                    generatorCommander.usage();
                    System.exit(0);
                }
                generator.setOptions(generatorOptions);
                generator.populateOptions(args);
                
            }
            ModelBuilder modelBuilder = new ModelBuilder(options);
            APIModel apiModel = modelBuilder.build();
            generator.setModel(apiModel);
            generator.print();
        } catch (ParameterException | IllegalAccessException | InstantiationException e) {
            System.out.println(String.format("ERROR: %s \n", e.getMessage()));
            commander.usage();
        }
        
        // We want default help to include generator options if they apply
        if (options.isHelp()) {
            commander.usage();
            System.exit(0);
        }
    }

    private static AbstractGenerator getGenerator(String generatorClassName) {

        if (StringUtils.isBlank(generatorClassName)) {
            throw new ParameterException("You must supply a generator name");
        }

        try {
            Class<?> targetGenerator = Class.forName(generatorClassName);
            return (AbstractGenerator) targetGenerator.newInstance();
        } catch (ClassNotFoundException e) {
            String message = String.format("The specified generator of \"%s\" is not found", generatorClassName);
            throw new ParameterException(message);
        } catch (ClassCastException | InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            String message = String.format("Unable to instantiate requested class %s due to: %s", generatorClassName, e.getCause());
            throw new ParameterException(message);
        }
    }

}
