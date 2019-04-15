package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.model.APIModel;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;

public class CodegenCLI {

    public static void main(String[] args) throws Exception {

        Options options = new Options();
        JCommander commander = JCommander.newBuilder().addObject(options).build();
        commander.setProgramName(CodegenCLI.class.getSimpleName());
        commander.parse(args);

        try {
            ModelBuilder modelBuilder = new ModelBuilder(options);
            APIModel apiModel = modelBuilder.build();
            AbstractGenerator generator = getGenerator(options.getGeneratorClassName(), apiModel);
            generator.populateOptions(args);
            if (options.isHelp()) {
                if (generator.hasOptions()) generator.usage();
                else commander.usage();
            } else {
                generator.print();
            }
        } catch (ParameterException | IllegalAccessException | InstantiationException e) {
            System.out.println(String.format("ERROR: %s \n", e.getMessage()));
            commander.usage();
        }
    }

    private static AbstractGenerator getGenerator(String generatorClassName, APIModel apiModel) {

        if (StringUtils.isBlank(generatorClassName)) {
            throw new ParameterException("You must supply a generator name");
        }

        try {
            Class<?> targetGenerator = Class.forName(generatorClassName);
            return (AbstractGenerator) targetGenerator.getConstructor(APIModel.class).newInstance(apiModel);
        } catch (ClassNotFoundException e) {
            String message = String.format("The specified generator of \"%s\" is not found", generatorClassName);
            throw new ParameterException(message);
        } catch (InvocationTargetException | NoSuchMethodException | ClassCastException | InstantiationException
            | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            String message = String.format("Unable to instantiate requested class %s due to: %s", generatorClassName, e.getCause());
            throw new ParameterException(message);
        }
    }

}
