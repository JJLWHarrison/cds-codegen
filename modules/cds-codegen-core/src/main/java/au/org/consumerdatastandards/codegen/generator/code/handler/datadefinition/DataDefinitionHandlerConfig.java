package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import java.lang.reflect.Field;
import java.util.Map;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class DataDefinitionHandlerConfig extends AbstractHandlerConfig {
    public String templateName;
    public String fileName;
    public String filePath;
    
    public String getTemplateName() {
        return templateName;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFilePath() {
        return filePath;
    }

    
}
