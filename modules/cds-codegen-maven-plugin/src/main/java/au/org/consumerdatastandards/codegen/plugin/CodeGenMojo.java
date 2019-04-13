package au.org.consumerdatastandards.codegen.plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import au.org.consumerdatastandards.codegen.ModelBuilder;
import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.generator.java.ClientGenerator;
import au.org.consumerdatastandards.codegen.generator.openapi.SwaggerGenerator;
import au.org.consumerdatastandards.codegen.model.APIModel;
import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.codegen.config.CodegenConfigurator;

/**
 * Goal which generates sources from cds-models Current Method is: cds-models
 * [input to] cds-codegen [creates] swagger.json [inputs into] swagger-codegen
 * [outpust] codegen output (java client etc)
 * 
 * Future path is: cds-models [input to] cds-codegen [outputs] codegen output
 * (java client etc)
 *
 */
@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CodeGenMojo extends AbstractMojo {

    public enum GENERATOR {
        SWAGGER_CODEGEN, CDS_CODEGEN
    }

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
    @Parameter(name = "outputDirectory", required = true, property = "au.org.consumerdatastandards.codegen.maven.plugin.outputdirectory")
    private File outputDirectory;

    /**
     * What are we using to generate?
     */
    @Parameter(name = "generatorEngine", required = true, property = "au.org.consumerdatastandards.codegen.maven.plugin.generatorengine")
    private GENERATOR generatorEngine = GENERATOR.SWAGGER_CODEGEN;

    /**
     * Included sections in generation
     */
    @Parameter(name = "includedSections", required = false, property = "au.org.consumerdatastandards.codegen.maven.plugin.includesections")
    private List<String> includedSections;

    /**
     * Excluded sections in generation
     */
    @Parameter(name = "excludedSections", required = false, property = "au.org.consumerdatastandards.codegen.maven.plugin.excludedsections")
    private List<String> excludedSections;

    @Override
    public void execute() throws MojoExecutionException {

        /**
         * First produce a swagger.json using cds-codegen with cds-models
         */
        Options cliModel = new Options(includedSections, excludedSections);
        ModelBuilder modelBuilder = new ModelBuilder(cliModel);
        APIModel apiModel = modelBuilder.build();

        String generatedSwagger = (new SwaggerGenerator(apiModel)).toString();

        try {

            BufferedWriter generatedSwaggerFileWriter = new BufferedWriter(new FileWriter(generatedSwaggerFile));
            System.out.println(generatedSwagger);
            generatedSwaggerFileWriter.write(generatedSwagger);
            generatedSwaggerFileWriter.close();
        } catch (IOException e1) {
            throw new MojoExecutionException("Couldn't generated file for writing");
        }

        if (generatorEngine.equals(GENERATOR.SWAGGER_CODEGEN)) {
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
                //inputOptions.swagger((new SwaggerGenerator(apiModel)).generateSwagger());
                new DefaultGenerator().opts(inputOptions).generate();
            } catch (Exception e) {
                getLog().error(e);
                throw new MojoExecutionException(
                        "cds-codegen attempted to execute swagger-codegen and failed, see details above");
            }
        } else if(generatorEngine.equals(GENERATOR.CDS_CODEGEN)) {
            
            CodegenModel myCodegenModel = new CodegenModel();
            ClientGenerator myGenerator = new ClientGenerator();
            try {
                myGenerator.generate(myCodegenModel);
            } catch (Exception e) {
                throw new MojoExecutionException(e.toString());
            }

        } else {
            throw new MojoExecutionException(
                    "cds-codegen attempted to execute with unknown generatorEngine");
      
        }

    }

}
