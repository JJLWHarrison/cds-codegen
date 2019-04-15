package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.codegen.model.APIModel;
import com.beust.jcommander.JCommander;

public abstract class AbstractGenerator<O extends Options>  {

    protected O options;

    protected APIModel apiModel;

    private JCommander commander = null;

    public AbstractGenerator(APIModel apiModel) {
        this.apiModel = apiModel;
    }

    abstract public void generate() throws Exception;

    abstract public void print() throws Exception;

    abstract protected O createOptions();

    public void populateOptions(String[] commandLineArgs) {
        O options = createOptions();
        if (options != null) {
            commander = JCommander.newBuilder().addObject(options).build();
            commander.parse(commandLineArgs);
        }
        this.options = options;
    }

    public boolean hasOptions() {
        return options != null;
    }

    public void usage() {
        if (commander != null) commander.usage();
    }
}
