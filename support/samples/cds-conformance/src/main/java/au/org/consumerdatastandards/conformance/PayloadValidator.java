package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.codegen.ModelBuilder;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.conformance.util.ModelConformanceConverter;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.PostConstruct;

@ShellComponent
public class PayloadValidator {

    private static ConformanceModel conformanceModel;

    @PostConstruct
    public void init() {
        ModelBuilder modelBuilder = new ModelBuilder(new Options());
        conformanceModel = ModelConformanceConverter.convert(modelBuilder.build());
    }

    @ShellMethod("Validate json payload(s) against cds-model")
    public void validate(@ShellOption(value = "-f", help = "payload file or folder") String payloadFileOrFolder) {

    }
}
