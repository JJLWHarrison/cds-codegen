package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.model.*;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.data.Property;
import au.org.consumerdatastandards.support.data.*;
import io.swagger.models.*;
import io.swagger.models.parameters.*;
import io.swagger.models.properties.*;
import io.swagger.models.utils.PropertyModelConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class ModelSwaggerConverter {

    private static final Logger logger = LoggerFactory.getLogger(ModelSwaggerConverter.class);

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

    private static class SwaggerTypeFormat {
        String type = ObjectProperty.TYPE, format;
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
        setPaths(swagger, apiModel);
        setDefinitions(swagger, apiModel);
        // TODO setVendorExtensions
        // TODO support MapProperty ComposedModel
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

    private static void setPaths(Swagger swagger, APIModel apiModel) {

        logger.debug("Setting paths");
        for (SectionModel sectionModel : apiModel.getSectionModels()) {
            List<String> tags = Arrays.asList(sectionModel.getTags());
            for (EndpointModel endpointModel : sectionModel.getEndpointModels()) {
                Endpoint endpoint = endpointModel.getEndpoint();
                String method = endpoint.requestMethod().toString().toLowerCase();
                Operation operation = new Operation().operationId(endpoint.operationId())
                    .description(endpoint.description())
                    .summary(endpoint.summary())
                    .tags(tags);
                for (EndpointResponse response : endpoint.responses()) {
                    operation = operation.response(response.responseCode().getCode(),
                        new Response().description(response.description())
                            .responseSchema(convertToModel(response.content())));
                }
                for (ParamModel paramModel : endpointModel.getParamModels()) {
                    operation.parameter(convertToParameter(swagger, paramModel));
                }
                Path path = new Path().set(method, operation);
                swagger = swagger.path(endpoint.path(), path);
            }
        }
    }

    private static void setDefinitions(Swagger swagger, APIModel apiModel) {

        logger.debug("Setting definitions");
        Map<String, Model> definitions = new HashMap<>();
        for (DataDefinitionModel dataDefinitionModel : apiModel.getDataDefinitionModels()) {
            Class dataType = dataDefinitionModel.getDataType();
            definitions.put(dataType.getSimpleName(), convertToModelImpl(dataType));
        }
        swagger.setDefinitions(definitions);
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

    private static Parameter convertToParameter(Swagger swagger, ParamModel paramModel) {

        Param param = paramModel.getParam();
        switch (param.in()) {
            case BODY:
                BodyParameter bodyParameter = new BodyParameter()
                    .description(param.description())
                    .name(param.name()).schema(convertToModel(paramModel.getParamDataType()));

                if (param.reference() && !paramModel.isSimple()) {
                    return buildRefParameter(swagger, paramModel, bodyParameter);
                }
                return bodyParameter;
            case HEADER:
                HeaderParameter headerParameter = new HeaderParameter();
                buildSerializableParameter(paramModel, param, headerParameter);
                if (param.reference() && !paramModel.isSimple()) {
                    return buildRefParameter(swagger, paramModel, headerParameter);
                }
                return headerParameter;
            case PATH:
                PathParameter pathParameter = new PathParameter();
                buildSerializableParameter(paramModel, param, pathParameter);
                if (param.reference() && !paramModel.isSimple()) {
                    return buildRefParameter(swagger, paramModel, pathParameter);
                }
                return pathParameter;
            case FORM:
                FormParameter formParameter = new FormParameter();
                buildSerializableParameter(paramModel, param, formParameter);
                if (param.reference() && !paramModel.isSimple()) {
                    return buildRefParameter(swagger, paramModel, formParameter);
                }
                return formParameter;
            case QUERY:
                QueryParameter queryParameter = new QueryParameter();
                buildSerializableParameter(paramModel, param, queryParameter);
                if (param.reference() && !paramModel.isSimple()) {
                    return buildRefParameter(swagger, paramModel, queryParameter);
                }
                return queryParameter;
            case COOKIE:
                CookieParameter cookieParameter = new CookieParameter();
                buildSerializableParameter(paramModel, param, cookieParameter);
                if (param.reference() && !paramModel.isSimple()) {
                    return buildRefParameter(swagger, paramModel, cookieParameter);
                }
                return cookieParameter;
            default:
                throw new Error("unsupported ParamLocation " + param.in());
        }
    }

    private static Parameter buildRefParameter(Swagger swagger, ParamModel paramModel, Parameter parameter) {
        String ref = paramModel.generateRef();
        swagger.parameter(ref, parameter);
        return new RefParameter(ref);
    }

    private static void buildSerializableParameter(ParamModel paramModel, Param param, AbstractSerializableParameter parameter) {
        SwaggerTypeFormat swaggerTypeFormat = getSwaggerTypeFormat(paramModel.getParamDataType());
        if (paramModel.getStringFormat() != null) {
            swaggerTypeFormat.format = paramModel.getStringFormat().format().toString();
        }
        parameter
            .description(param.description())
            .name(param.name())
            .type(swaggerTypeFormat.type)
            .format(swaggerTypeFormat.format);
        if (!StringUtils.isBlank(param.defaultValue())) {
            parameter.setDefaultValue(param.defaultValue());
        }
        if (paramModel.getPattern() != null) {
            parameter.setPattern(paramModel.getPattern().regex());
        }
        IntegerRange integerRange = paramModel.getIntegerRange();
        if (integerRange != null) {
            if (integerRange.min() != Integer.MIN_VALUE) {
                parameter.setMinimum(new BigDecimal(integerRange.min()));
            }
            if (integerRange.max() != Integer.MAX_VALUE) {
                parameter.setMaximum(new BigDecimal(integerRange.max()));
            }
        }
        if (paramModel.getParamDataType().isEnum()) {
            parameter.setEnum(getEnumValues(paramModel.getParamDataType()));
        }
    }

    private static Model convertToModel(Class contentClass) {

        Annotation dataDefinition = contentClass.getAnnotation(DataDefinition.class);
        if (dataDefinition == null) {
            return convertToModelImpl(contentClass);
        } else {
            return new RefModel(contentClass.getSimpleName());
        }
    }

    private static ModelImpl convertToModelImpl(Class contentClass) {

        ModelImpl modelImpl = new ModelImpl();
        modelImpl = modelImpl.name(contentClass.getSimpleName()).type(ModelImpl.OBJECT);
        List<String> required = new ArrayList<>();
        for (Field field : FieldUtils.getAllFields(contentClass)) {
            if (field.isAnnotationPresent(Property.class)) {
                Property property = field.getAnnotation(Property.class);
                if (property.required()) {
                    required.add(field.getName());
                }
                modelImpl.addProperty(field.getName(), convertToProperty(field));
            }
        }
        modelImpl.setRequired(required);
        return modelImpl;
    }

    private static io.swagger.models.properties.Property convertToProperty(Field field) {

        // figure out swagger type and format from field
        SwaggerTypeFormat typeFormat = getSwaggerTypeFormat(field.getType());
        StringFormat stringFormat = field.getAnnotation(StringFormat.class);
        if (stringFormat != null) {
            typeFormat.format = stringFormat.format().toString();
        }

        return buildProperty(field, typeFormat);
    }


    private static io.swagger.models.properties.Property buildProperty(Field field, SwaggerTypeFormat typeFormat) {

        if (ObjectProperty.isType(typeFormat.type, typeFormat.format)) {
            Class<?> fieldType = field.getType();
            if (fieldType.isAnnotationPresent(DataDefinition.class)) {
                return new RefProperty(fieldType.getSimpleName());
            } else {
                return buildObjectProperty(fieldType);
            }
        } else if (ArrayProperty.isType(typeFormat.type)) {
            return buildArrayProperty(field, typeFormat);
        } else {
            return PropertyBuilder.build(typeFormat.type, typeFormat.format, argsFromField(field, false));
        }
    }

    private static io.swagger.models.properties.Property buildArrayProperty(Field field, SwaggerTypeFormat typeFormat) {
        ArrayProperty arrayProperty = new ArrayProperty();
        Property property = field.getAnnotation(Property.class);
        if (!StringUtils.isBlank(property.description())) {
            arrayProperty.description(property.description());
        }
        Class<?> componentType = field.getType().getComponentType();
        Map<PropertyBuilder.PropertyId, Object> args = argsFromField(field, true);
        arrayProperty.setItems(convertItemToProperty(componentType, typeFormat.format, args));
        return arrayProperty;
    }


    private static io.swagger.models.properties.Property buildItemsProperty (
        Class<?> type,
        SwaggerTypeFormat typeFormat,
        Map<PropertyBuilder.PropertyId, Object> args
    ) {
        if (ObjectProperty.isType(typeFormat.type, typeFormat.format)) {
            return buildObjectProperty(type);
        } else if (ArrayProperty.isType(typeFormat.type)) {
            ArrayProperty arrayProperty = new ArrayProperty();
            Class<?> componentType = type.getComponentType();
            arrayProperty.setItems(convertItemToProperty(componentType, typeFormat.format, args));
            return arrayProperty;
        }
        return PropertyBuilder.build(typeFormat.type, typeFormat.format, args);
    }

    private static io.swagger.models.properties.Property buildObjectProperty(Class<?> fieldType) {

        ModelImpl model = convertToModelImpl(fieldType);
        return new PropertyModelConverter().modelToProperty(model);
    }

    private static SwaggerTypeFormat getSwaggerTypeFormat(Class<?> type) {

        SwaggerTypeFormat swaggerTypeFormat = new SwaggerTypeFormat();
        if (type.isArray()) {
            swaggerTypeFormat.type = ArrayProperty.TYPE;
        } else if (type.isEnum()) {
            swaggerTypeFormat.type = StringProperty.TYPE;
        } else {
            String mappedTypeFormat = TYPE_MAPPING.getProperty(type.getSimpleName().toLowerCase());
            if (mappedTypeFormat != null) {
                String[] typeAndFormat = getTrimmedValues(mappedTypeFormat.split(","));
                if (typeAndFormat.length == 1) {
                    swaggerTypeFormat.type = typeAndFormat[0];
                } else if (typeAndFormat.length == 2) {
                    swaggerTypeFormat.type = typeAndFormat[0];
                    swaggerTypeFormat.format = typeAndFormat[1];
                } else {
                    throw new Error("Too many commas in '" + mappedTypeFormat + "'");
                }
            }
        }
        return swaggerTypeFormat;
    }

    private static io.swagger.models.properties.Property convertItemToProperty(
        Class<?> type,
        String format,
        Map<PropertyBuilder.PropertyId, Object> args
    ) {
        SwaggerTypeFormat typeFormat = getSwaggerTypeFormat(type);
        if (!type.isArray() && !StringUtils.isBlank(format)) {
            typeFormat.format = format;
        }
        if (!type.isArray()) {
            setEnum(type, args);
        }
        return buildItemsProperty(type, typeFormat, args);
    }

    private static Map<PropertyBuilder.PropertyId, Object> argsFromField(Field field, boolean forItem) {

        Map<PropertyBuilder.PropertyId, Object> args = new HashMap<>();
        if (forItem) {
            setItemDescription(field, args);
        } else {
            setDescription(field, args);
        }
        setEnum(field.getType(), args);
        setMinMax(field, args);
        setFormat(field, args);
        setPattern(field, args);
        setDefaultValue(field, args);
        return args;
    }

    private static void setDescription(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        Property property = field.getAnnotation(Property.class);
        if (!StringUtils.isBlank(property.description())) {
            args.put(PropertyBuilder.PropertyId.DESCRIPTION, property.description());
        }
    }

    private static void setItemDescription(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        Item element = field.getAnnotation(Item.class);
        if (element != null && !StringUtils.isBlank(element.description())) {
            args.put(PropertyBuilder.PropertyId.DESCRIPTION, element.description());
        }
    }

    private static void setEnum(Class<?> type, Map<PropertyBuilder.PropertyId, Object> args) {

        if (type.isEnum()) {
            List<String> values = getEnumValues(type);
            args.put(PropertyBuilder.PropertyId.ENUM, values);
        }
    }

    private static List<String> getEnumValues(Class<?> type) {

        Object[] enumConstants = type.getEnumConstants();
        List<String> values = new ArrayList<>(enumConstants.length);
        for (Object enumConstant : enumConstants) {
            values.add(((Enum) enumConstant).name());
        }
        return values;
    }

    private static void setFormat(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        StringFormat stringFormat = field.getAnnotation(StringFormat.class);
        if (stringFormat != null) {
            args.put(PropertyBuilder.PropertyId.FORMAT, stringFormat.format().toString());
        }
    }

    private static void setPattern(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        Pattern pattern = field.getAnnotation(Pattern.class);
        if (pattern != null) {
            args.put(PropertyBuilder.PropertyId.PATTERN, pattern.regex());
        }
    }

    private static void setMinMax(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        IntegerRange integerRange = field.getAnnotation(IntegerRange.class);
        if (integerRange != null) {
            if (integerRange.min() != Integer.MIN_VALUE) {
                args.put(PropertyBuilder.PropertyId.MINIMUM, new BigDecimal(integerRange.min()));
            }
            if (integerRange.max() != Integer.MAX_VALUE) {
                args.put(PropertyBuilder.PropertyId.MAXIMUM, new BigDecimal(integerRange.max()));
            }
        }
    }

    private static void setDefaultValue(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        try {
            Object target = field.getDeclaringClass().newInstance();
            Object defaultValue = FieldUtils.readField(field, target, true);
            if (defaultValue != null && !isTypeDefaultValue(defaultValue)) {
                if (defaultValue.getClass().isEnum()) {
                    args.put(PropertyBuilder.PropertyId.DEFAULT, ((Enum) defaultValue).name());
                } else {
                    args.put(PropertyBuilder.PropertyId.DEFAULT, defaultValue.toString());
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    private static boolean isTypeDefaultValue(Object defaultValue) {

        return defaultValue.getClass().equals(Boolean.class) && defaultValue.equals(Boolean.FALSE)
            || Number.class.isAssignableFrom(defaultValue.getClass()) && ((Number) defaultValue).intValue() == 0;
    }
}
