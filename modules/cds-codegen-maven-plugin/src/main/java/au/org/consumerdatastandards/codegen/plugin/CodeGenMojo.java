package au.org.consumerdatastandards.codegen.plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import au.org.consumerdatastandards.codegen.ModelBuilder;
import au.org.consumerdatastandards.codegen.ModelBuilderOptions;
import au.org.consumerdatastandards.codegen.generator.SwaggerGenerator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.codegen.config.CodegenConfigurator;
import io.swagger.models.Swagger;
import io.swagger.util.Json;

/**
 * Goal which generates sources from cds-models 
 * Current Method is: 
 *  cds-models [input to] 
 *  cds-codegen [creates] 
 *  swagger.json [inputs into] 
 *  swagger-codegen [outpust] 
 *  codegen output (java client etc)
 *  
 *  Future path is:
 *   cds-models [input to]
 *   cds-codegen [outputs]
 *   codegen output (java client etc)
 *
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CodeGenMojo extends AbstractMojo {
    /**
     * Verbosity enabled
     */
    @Parameter(name = "verbose", required = false, defaultValue = "false")
    private boolean verbose;

    /**
     * Client language to generate.
     */
    @Parameter(name = "language", required = true)
    private String language;
    
    /**
     * Generated file location
     */
    @Parameter(name = "generatedSwaggerFile", required = false, defaultValue = "cds-codegen-generated-swagger.json")
    private String generatedSwaggerFile;
    
    /**
     * Location of the output directory.
     */
    @Parameter(name = "outputDirectory", required = true, property = "au.org.consumerdatastandards.codegen.maven.plugin.outputdirectory"
            )
    private File outputDirectory;
    
    /**
     * Included sections in generation
     */
    @Parameter(name = "includedSections", required = false, property = "au.org.consumerdatastandards.codegen.maven.plugin.includesections"
            )
    private List<String> includedSections;
    
    /**
     * Excluded sections in generation
     */
    @Parameter(name = "excludedSections", required = false, property = "au.org.consumerdatastandards.codegen.maven.plugin.excludedsections"
            )
    private List<String> excludedSections;

    @Override
    public void execute() throws MojoExecutionException {

        /**
         * First produce a swagger.json using cds-codegen with cds-models
         */
        ModelBuilderOptions modelBuilderOptions = new ModelBuilderOptions();
        if(includedSections != null) {
            modelBuilderOptions.includedSections(includedSections);
        }
        
        if(excludedSections != null) {
            modelBuilderOptions.excludedSections(excludedSections);
        }
        
        ModelBuilder modelBuilder = new ModelBuilder(modelBuilderOptions);
        APIModel apiModel = modelBuilder.build();
        Swagger generatedSwagger = SwaggerGenerator.convert(apiModel);
        
        
        try {
            
            BufferedWriter generatedSwaggerFileWriter = new BufferedWriter(new FileWriter(generatedSwaggerFile));
            System.out.println(Json.pretty(generatedSwagger));
            generatedSwaggerFileWriter.write(Json.pretty(generatedSwagger));
            generatedSwaggerFileWriter.close();
        } catch (IOException e1) {
            throw new MojoExecutionException("Couldn't generated file for writing");
        }
        

        /**
         * Now, hot-wire into swagger codegen TODO: Replace with native cds-codegen
         */
        CodegenConfigurator configurator = new CodegenConfigurator();
        configurator.setVerbose(verbose);
        configurator.setLang(language);
        configurator.setInputSpec(generatedSwaggerFile);
        configurator.setOutputDir(outputDirectory.getAbsolutePath());

        try {
            ClientOptInput inputOptions = configurator.toClientOptInput();
            //inputOptions.setSwagger(generatedSwagger);
            new DefaultGenerator().opts(inputOptions).generate();
        } catch (Exception e) {
            getLog().error(e);
            throw new MojoExecutionException("cds-codegen attempted to execute swagger-codegen and failed, see details above");
        }

    }

}
