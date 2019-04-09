package au.org.consumerdatastandards.codegen.model;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CLIModel {
    private String generatorTarget = "swagger";    
    private Set<String> includedSections = new LinkedHashSet<>();
    private Set<String> excludedSections = new LinkedHashSet<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(CLIModel.class);
    public String PACKAGE_NAME = "au.org.consumerdatastandards.codegen";

    
    public Options getCommandLineOptions() {
        Options options = new Options();
        options.addOption("g", "generator", true, "Which generator to use (default: swagger)");
        options.addOption("i", "include", true, "Sections to include");
        options.addOption("p", "package", true, PACKAGE_NAME);
        options.addOption("x", "exclude", true, "Sections to exclude");
        return options;
    }
    
    public String getGeneratorTarget() {
        return generatorTarget;
    }
    
    public Set<String> getIncludedSections() {
        return includedSections;
    }
    
    public Set<String> getExcludedSections() {
        return excludedSections;
    }    
    
    private Set<Class<? extends CLIModel>> getCliModels() {
        Reflections reflections = new Reflections(PACKAGE_NAME);
        return reflections.getSubTypesOf(CLIModel.class);
    }
    
    public void parseCommandLine(String[] inputArguments) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(getCommandLineOptions(), inputArguments);
        
        /**
         * Check conflicting include/exclude
         */
        if (cmd.hasOption("i") && cmd.hasOption("x")) {
            throw new Error("Either included sections or excluded sections can be specified, but not both");
        }
        
        /**
         * Parse generator to use
         */
        if(cmd.hasOption("g")) {
            boolean foundGenerator = false;
            for (Class<? extends CLIModel> cliModelClass: getCliModels()) {
                try {
                    CLIModel thisCli = cliModelClass.getConstructor().newInstance();
                    if(thisCli.getGeneratorTarget().equals(cmd.getOptionValue('g')) ) {
                        generatorTarget = cmd.getOptionValue('g');
                        foundGenerator = true;
                    }
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                        | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                    LOGGER.warn("Instantiation exception while trying to initialise: " + cliModelClass.getSimpleName());
                }
            }
            
            if(!foundGenerator) {
                throw new Error(String.format("Unable to find generator %s", cmd.getOptionValue('g')));
            }
        }

        /**
         * Parse include/exclude
         */
        if (cmd.hasOption("i")) {
            includedSections.addAll(Arrays.asList(cmd.getOptionValue('i').split(",")));
        } else if (cmd.hasOption("x")) {
            excludedSections.addAll(Arrays.asList(cmd.getOptionValue('x').split(",")));
        }
    }
    

}
