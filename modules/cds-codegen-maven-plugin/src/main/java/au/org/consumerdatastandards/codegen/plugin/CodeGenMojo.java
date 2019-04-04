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

/**
 * Goal which generates sources from cds-models
 * Current Path is: cds-models -> cds-codegen -> swagger.json -> swagger-codegen -> codegen output (java client etc)
 * Future path is: cds-models -> cds-codegen -> codegen output (java client etc)
 */
@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CodeGenMojo extends AbstractMojo {
    /**
     * Client language to generate.
     */
    @Parameter(name = "language", required = true)
    private String language;


    @Override
    public void execute() throws MojoExecutionException {

    }

}
