package au.org.consumerdatastandards.codegen.generator.code.handler;

import com.beust.jcommander.JCommander;

import au.org.consumerdatastandards.codegen.generator.code.handler.model.ModelHandlerConfig;

public abstract class AbstractHandler<O extends AbstractHandlerConfig>  {
    protected O config;
    abstract public boolean matchConfig(AbstractHandlerConfig inputConfig);
    abstract public void productOutput();
    abstract public void setConfig(AbstractHandlerConfig inputConfig);
    
}