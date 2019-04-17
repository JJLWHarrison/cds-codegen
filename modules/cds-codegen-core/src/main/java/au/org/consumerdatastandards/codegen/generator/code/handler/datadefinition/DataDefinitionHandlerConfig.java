package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class DataDefinitionHandlerConfig extends AbstractHandlerConfig {
    public String modelTemplate;
    public String enumTemplate;
    public String fileName;
    public String filePath;
    
    public String getModelTemplate() {
        return modelTemplate;
    }
    public String getEnumTemplate() {
        return enumTemplate;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFilePath() {
        return filePath;
    }

    
}
