package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.DataDefinitionModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.data.Enum;
import au.org.consumerdatastandards.support.data.Property;
import io.swagger.models.*;
import io.swagger.models.properties.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class ModelSwaggerConverter {

    private static Properties TYPE_MAPPING;

    static {
        TYPE_MAPPING = new Properties();
        InputStream inputStream = ModelSwaggerConverter.class.getResourceAsStream("/swagger/java-swagger-mapping.properties");
        try {
            TYPE_MAPPING.load(inputStream);
        } catch (IOException e) {
            throw new Error("missing static-values.properties file");
        }
    }

    public static Swagger convert(APIModel apiModel) {
        Swagger swagger = new Swagger();
        Properties swaggerProp = loadSwaggerProperties();
        swagger = swagger.info(getInfo(swaggerProp))
            .host(swaggerProp.getProperty("host"))
            .basePath(swaggerProp.getProperty("basePath"))
            .schemes(Arrays.asList(getSchemes(swaggerProp)))
            .produces(Arrays.asList(getTrimmedValues(swaggerProp.getProperty("produces").split(","))))
            .consumes(Arrays.asList(getTrimmedValues(swaggerProp.getProperty("consumes").split(","))));
        swagger = setPaths(swagger, apiModel);
        swagger = setDefinitions(swagger, apiModel);
        // TODO setParameters setResponses setSecurityDefinitions setSecurity setExternalDocs setVendorExtensions
        // TODO support tags self4j default
        return swagger;
    }

    private static Info getInfo(Properties swaggerProp) {
        Info info = new Info();
        info.version(swaggerProp.getProperty("version"))
            .title(swaggerProp.getProperty("title"))
            .description(swaggerProp.getProperty("description"))
            .license(new License().name(swaggerProp.getProperty("license.name"))
                .url(swaggerProp.getProperty("license.url")));
        return info;
    }

    private static Scheme[] getSchemes(Properties swaggerProp) {
        String[] schemeNames = swaggerProp.getProperty("schemes").split(",");
        Scheme[] schemes = new Scheme[schemeNames.length];
        for (int i = 0; i < schemeNames.length; i++) {
            schemes[i] = Scheme.forValue(schemeNames[i].trim());
        }
        return schemes;
    }

    private static String[] getTrimmedValues(String[] values) {
        String[] trimmedValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            trimmedValues[i] = values[i].trim();
        }
        return trimmedValues;
    }

    private static Swagger setPaths(Swagger swagger, APIModel apiModel) {
        for (SectionModel sectionModel : apiModel.getSectionModels()) {
            for (Endpoint endpoint : sectionModel.getEndpoints()) {
                String method = endpoint.requestMethod().toString().toLowerCase();
                Operation operation = new Operation().operationId(endpoint.operationId())
                    .description(endpoint.description())
                    .summary(endpoint.summary());
                for (EndpointResponse response : endpoint.responses()) {
                    operation = operation.response(response.responseCode().getCode(),
                        new Response().description(response.description())
                            .responseSchema(convert(response.content())));
                }
                Path path = new Path().set(method, operation);
                swagger = swagger.path(endpoint.path(), path);
            }
        }
        return swagger;
    }

    private static Swagger setDefinitions(Swagger swagger, APIModel apiModel) {
        Map<String, Model> definitions = new HashMap<>();
        for (DataDefinitionModel dataDefinitionModel : apiModel.getDataDefinitionModels()) {
            Class dataType = dataDefinitionModel.getDataType();
            definitions.put(dataType.getSimpleName(), convertToModelImpl(dataType));
        }
        swagger.setDefinitions(definitions);
        return swagger;
    }

    private static Properties loadSwaggerProperties() {
        Properties prop = new Properties();
        InputStream inputStream = ModelSwaggerConverter.class.getResourceAsStream("/swagger/static-values.properties");
        try {
            prop.load(inputStream);
            return prop;
        } catch (IOException e) {
            throw new Error("missing static-values.properties file");
        }
    }

    private static Model convert(Class contentClass) {
        Annotation dataDefinition = contentClass.getAnnotation(DataDefinition.class);
        if (dataDefinition == null) {
            return convertToModelImpl(contentClass);
        } else {
            return new RefModel(contentClass.getSimpleName());
        }
    }

    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private static ModelImpl convertToModelImpl(Class contentClass) {
        ModelImpl modelImpl = new ModelImpl();
        modelImpl = modelImpl.name(contentClass.getSimpleName());
        List<String> required = new ArrayList<>();
        List<Field> allFields = new ArrayList<>();
        for (Field field : getAllFields(allFields, contentClass)) {
            if (field.isAnnotationPresent(Property.class)) {
                Property property = field.getAnnotation(Property.class);
                if (property.required()) {
                    required.add(field.getName());
                }
                modelImpl.addProperty(field.getName(), convert(field));
            }
        }
        modelImpl.setRequired(required);
        return modelImpl;
    }

    private static io.swagger.models.properties.Property convert(Field field) {
        String type = ObjectProperty.TYPE, format = null;
        Class<?> fieldType = field.getType();
        if (fieldType.isArray()) {
            type = ArrayProperty.TYPE;
        } else if (fieldType.isEnum()) {
            type = StringProperty.TYPE;
        } else {
            String mappedTypeFormat = TYPE_MAPPING.getProperty(fieldType.getSimpleName().toLowerCase());
            if (mappedTypeFormat != null) {
                String[] typeAndFormat = getTrimmedValues(mappedTypeFormat.split(","));
                if (typeAndFormat.length == 1) {
                    type = typeAndFormat[0];
                } else if (typeAndFormat.length == 2) {
                    type = typeAndFormat[0];
                    format = typeAndFormat[1];
                } else {
                    throw new Error("Too many commas in '" + mappedTypeFormat + "'");
                }
            }
        }
        StringFormat stringFormat = field.getAnnotation(StringFormat.class);
        if (stringFormat != null) {
            format = stringFormat.format().toString();
        }
        io.swagger.models.properties.Property property = PropertyBuilder.build(type, format, argsFromField(field));
        if (property instanceof ObjectProperty) {
            if (fieldType.isAnnotationPresent(DataDefinition.class)) {
                return new RefProperty(fieldType.getSimpleName());
            } else {
                ModelImpl model = convertToModelImpl(fieldType);
                ((ObjectProperty) property).properties(model.getProperties());
                if (model.getRequired() != null) {
                    ((ObjectProperty) property).setRequiredProperties(model.getRequired());
                }
            }
        }
        return property;
    }

    private static Map<PropertyBuilder.PropertyId, Object> argsFromField(Field field) {
        Map<PropertyBuilder.PropertyId, Object> args = new HashMap<>();
        Property property = field.getAnnotation(Property.class);
        args.put(PropertyBuilder.PropertyId.DESCRIPTION, property.description());
        Enum enumerator = field.getAnnotation(Enum.class);
        if (enumerator != null) {
            args.put(PropertyBuilder.PropertyId.ENUM, Arrays.asList(enumerator.values()));
        } else if (field.getType().isEnum()) {
            Object[] enumConstants = field.getType().getEnumConstants();
            List<String> values = new ArrayList<>(enumConstants.length);
            for(Object enumConstant : enumConstants) {
                values.add(((java.lang.Enum)enumConstant).name());
            }
            args.put(PropertyBuilder.PropertyId.ENUM, values);
        }
        IntegerRange integerRange = field.getAnnotation(IntegerRange.class);
        if (integerRange != null) {
            if (integerRange.min() != Integer.MIN_VALUE) {
                args.put(PropertyBuilder.PropertyId.MINIMUM, new BigDecimal(integerRange.min()));
            }
            if (integerRange.max() != Integer.MAX_VALUE) {
                args.put(PropertyBuilder.PropertyId.MAXIMUM, new BigDecimal(integerRange.max()));
            }
        }
        return args;
    }
}
