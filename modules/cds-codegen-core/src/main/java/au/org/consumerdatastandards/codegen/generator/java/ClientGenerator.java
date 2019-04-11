package au.org.consumerdatastandards.codegen.generator.java;

import au.org.consumerdatastandards.codegen.generator.Generator;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.model.APIModel;
import io.swagger.models.Swagger;

public class ClientGenerator extends Generator {
    
    private APIModel apiModel;
    
    public ClientGenerator(APIModel newModel) {
        super(newModel);
    }

    public ClientGenerator() {
        
    }
    
    @Override
    public void generate() {
        
    }

    @Override
    public Class getOptionsClass() {
        return ClientGeneratorOptions.class;
    }

    @Override
    public void print() {
        // If print has been called we should be generating first
        this.generate();
        System.out.println("Client Generator output printer");
    }

}
