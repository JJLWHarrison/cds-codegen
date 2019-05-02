package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.codegen.ModelBuilder;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.util.ReflectionUtil;
import au.org.consumerdatastandards.conformance.util.ModelConformanceConverter;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;
import com.google.gson.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@ShellComponent
public class PayloadValidator {

    private static ConformanceModel conformanceModel;

    @PostConstruct
    public void init() {
        ModelBuilder modelBuilder = new ModelBuilder(new Options());
        conformanceModel = ModelConformanceConverter.convert(modelBuilder.build());
    }

    @ShellMethod("Validate json payload(s) against cds-model")
    public void validate(@ShellOption(value = "-f", help = "payload file or folder") String fileOrFolder) {
        File file = new File(fileOrFolder);
        if (!file.exists()) {
            System.out.println("Cannot find " + fileOrFolder);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File oneFile : files) {
                validate(oneFile.getAbsolutePath());
            }
        } else {
            validate(file);
        }
    }

    private void validate(File jsonFile) {
        System.out.println("Validating " + jsonFile.getAbsolutePath());
        try {
            JsonElement jsonElement = new JsonParser().parse(new FileReader(jsonFile));
            validate(jsonElement);
        } catch (FileNotFoundException | JsonIOException | JsonSyntaxException e) {
            System.err.println(e.getMessage());
        }
    }

    private void validate(JsonElement jsonElement) {
        if (jsonElement.isJsonNull() || jsonElement.isJsonPrimitive()) {
            System.out.println("Null or primitive: " + jsonElement.toString());
        } else if (jsonElement.isJsonArray()) {
            // TODO array payload should be supported
            System.out.println("Array found " + jsonElement.toString());
        } else if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            String fieldsHash = generateFieldsHash(jsonObject);
            Class<?> clazz = conformanceModel.getClassByFields(fieldsHash);
            if (clazz == null) {
                System.out.println("Cannot find a model matching the structure");
            } else {
                validateJsonObject(jsonObject, clazz);
                Payload payload = conformanceModel.getPlayload(clazz);
                System.out.println("Found matching payload " + clazz.getSimpleName());
                System.out.println(payload.getDescription());
            }
        }
    }

    private void validate(JsonElement jsonElement, Class<?> type) {

    }

    private void validateJsonObject(JsonObject jsonObject, Class<?> clazz) {
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Field field = findField(clazz, entry.getKey());
            validate(entry.getValue(), field);
        }
    }

    private Field findField(Class<?> clazz, String fieldName) {
        Field field = FieldUtils.getField(clazz, fieldName);
        if (field != null) return field;
        DataDefinition dataDefinition = clazz.getAnnotation(DataDefinition.class);
        if (dataDefinition != null && dataDefinition.allOf().length > 0) {
            for (Class<?> aClass : dataDefinition.allOf()) {
                field = findField(aClass, fieldName);
                if (field != null) {
                    return field;
                }
            }
        }
        throw new Error("Couldn't find " + fieldName + " in model " + clazz.getSimpleName());
    }

    private void validate(JsonElement jsonElement, Field field) {
        Property property = field.getAnnotation(Property.class);
        if (jsonElement.isJsonNull()) {
            if (property != null && property.required()) {
                System.out.println("Required field " + field.getName() + " has NULL value");
            }
        } else if (jsonElement.isJsonPrimitive()) {
            if (field.getType().isEnum()) {
                Object[] enumConstants = field.getType().getEnumConstants();
                String s = jsonElement.getAsString();
                boolean found = false;
                for (Object constant : enumConstants) {
                    if (s.equals(((Enum<?>) constant).name())) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Cannot found enum value " + s + " in " + field.getType().getSimpleName());
                }
            } else if (!field.getType().isPrimitive()) {
                System.out.println("Non-primitive field " + field.getName() + " has primitive value " + jsonElement);
            }
        } else if (jsonElement.isJsonArray()) {
            if (!field.getType().isArray() && ReflectionUtil.isSetOrList(field.getType())) {
                System.out.println("Non-array field " + field.getName() + " has array value " + jsonElement);
            } else {
                Class<?> itemType;
                if (field.getType().isArray()) {
                    itemType = field.getType().getComponentType();
                } else {
                    itemType = ReflectionUtil.getItemType(field.getType(), field.getGenericType());
                }
                JsonArray jsonArray = (JsonArray) jsonElement;
                for (int i = 0; i < jsonArray.size(); i++) {
                    validate(jsonArray.get(i), itemType);
                }
            }
        } else if (jsonElement.isJsonObject()) {
            validateJsonObject((JsonObject) jsonElement, field.getType());
        }
    }


    private String generateFieldsHash(JsonObject jsonObject) {
        Set<String> ss = new TreeSet<>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            ss.add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return DigestUtils.sha256Hex(sb.toString());
    }
}
