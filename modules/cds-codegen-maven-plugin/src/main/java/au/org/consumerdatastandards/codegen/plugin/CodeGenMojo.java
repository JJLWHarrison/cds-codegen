package au.org.consumerdatastandards.codegen.plugin;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import au.org.consumerdatastandards.codegen.ModelBuilder;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.codegen.config.CodegenConfigurator;
import io.swagger.models.Swagger;

/**
 * Goal which generates sources from cds-models Current Path is: cds-models ->
 * cds-codegen -> swagger.json -> swagger-codegen -> codegen output (java client
 * etc) Future path is: cds-models -> cds-codegen -> codegen output (java client
 * etc)
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

    @Override
    public void execute() throws MojoExecutionException {

        /**
         * First produce a swagger.json using cds-codegen with cds-models
         */
        ModelBuilder modelBuilder = new ModelBuilder();
        APIModel apiModel = modelBuilder.build();
        Swagger swagger = ModelSwaggerConverter.convert(apiModel);

        /**
         * Now, hot-wire into swagger codegen TODO: Replace with native cds-codegen
         */
        CodegenConfigurator configurator = new CodegenConfigurator();
        configurator.setVerbose(verbose);
        configurator.setLang(language);

        try {
            new DefaultGenerator().opts(configurator.toClientOptInput()).generate();
        } catch (Exception e) {
            getLog().error(e);
            throw new MojoExecutionException("Swagger-codegen execution failed, see details above");
        }

    }

}
