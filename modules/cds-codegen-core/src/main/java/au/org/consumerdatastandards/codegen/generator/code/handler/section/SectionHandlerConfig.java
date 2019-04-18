package au.org.consumerdatastandards.codegen.generator.code.handler.section;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class SectionHandlerConfig extends AbstractHandlerConfig {
    public String sectionTemplate;
    public String fileName;
    public String filePath;
    
    public String getSectionTemplate() {
        return sectionTemplate;
    }
    public String getFileName() {
        return fileName;
    }
    public String getFilePath() {
        return filePath;
    }


    
}
