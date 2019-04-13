package au.org.consumerdatastandards.codegen.generator.velocity;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.velocity.model.CDSAnnotation;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;

public class VelocityHelperCDSAnnotation extends VelocityHelperDefault {
    public VelocityHelperCDSAnnotation(String inputPath) {
        super(inputPath);
    }
    
    
    public Set<Class<?>> getAnnotatedDefinitions(CodegenModel inputModel, CDSAnnotation inputAnnotationType) throws Exception {
        if(inputAnnotationType.equals(CDSAnnotation.DATA_DEFINITION)) {
            return inputModel.getDataDefinitions();
        } else if(inputAnnotationType.equals(CDSAnnotation.ENDPOINT_DEFINITION)) {
            return inputModel.getEndpointModels();
        }
        
        throw new Exception("Supplied annotation has no defined handler");
        
    }
}
