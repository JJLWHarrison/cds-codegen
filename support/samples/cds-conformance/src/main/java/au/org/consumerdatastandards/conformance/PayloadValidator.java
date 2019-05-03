package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.models.BankingProductBundle;
import au.org.consumerdatastandards.codegen.ModelBuilder;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.conformance.util.ModelConformanceConverter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class PayloadValidator {

    private static ConformanceModel conformanceModel;

    @PostConstruct
    public void init() {
        ModelBuilder modelBuilder = new ModelBuilder(new Options());
        conformanceModel = ModelConformanceConverter.convert(modelBuilder.build());
    }

    @ShellMethod("Validate json payload(s) against cds-model")
    public void validate(@ShellOption(value = "-f", help = "payload file or folder", defaultValue = "/home/yan149/IdeaProjects/cds-codegen/support/samples/cds-conformance/payloads/products") String fileOrFolder) throws IOException {
        File file = new File(fileOrFolder);
        if (!file.exists()) {
            System.out.println("Cannot find " + fileOrFolder);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File oneFile : files) {
                validate(oneFile.getAbsolutePath());
            }
        } else {
            if (!validate(file)) {
                System.out.println("No matching model found");
            }
        }
    }

    private boolean validate(File jsonFile) throws IOException {
        System.out.println("\nValidating " + jsonFile.getAbsolutePath());
        byte[] jsonData = Files.readAllBytes(Paths.get(jsonFile.getCanonicalPath()));
        for(Class<?> modelClass : conformanceModel.getPayloadModels()) {
            // TODO handle models with allOf annotation
            try {
                ObjectMapper objectMapper = new ObjectMapper()
                    .registerModule(new ParameterNamesModule())
                    .registerModule(new Jdk8Module())
                    .registerModule(new JavaTimeModule())
                    .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
                    .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                Object data = objectMapper.readValue(jsonData, modelClass);
                System.out.println("Found matching model " + modelClass.getSimpleName());
                List<String> errors = new ArrayList<>();
                ConformanceUtil.checkAgainstModel(data, modelClass, errors);
                if (errors.isEmpty()) {
                    Payload payload = conformanceModel.getPlayload(modelClass);
                    System.out.println(payload.getDescription());
                    return true;
                } else {
                    System.out.println("Errors found:");
                    errors.forEach(System.out::println);
                }
            } catch (JsonMappingException e) {
                // ignored
            }
        }
        return false;
    }
}
