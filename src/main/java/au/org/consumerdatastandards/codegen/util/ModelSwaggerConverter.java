package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.ModelBuilder;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.DataDefinitionModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;
import io.swagger.models.*;
import io.swagger.models.properties.IntegerProperty;
import io.swagger.models.properties.ObjectProperty;
import io.swagger.util.Json;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ModelSwaggerConverter {

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
        for(int i = 0; i < schemeNames.length; i++) {
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
        for(SectionModel sectionModel : apiModel.getSectionModels()) {
            for (Endpoint endpoint : sectionModel.getEndpoints()) {
                String method = endpoint.requestMethod().toString().toLowerCase();
                Operation operation = new Operation().operationId(endpoint.operationId())
                    .description(endpoint.description())
                    .summary(endpoint.summary());
                for(EndpointResponse response : endpoint.responses()){
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
            definitions.put(dataType.getSimpleName(), convert(dataType));
        }
        swagger.setDefinitions(definitions);
        return swagger;
    }

    private static Properties loadSwaggerProperties() {
        Properties prop = new Properties();
        InputStream inputStream = ModelSwaggerConverter.class.getResourceAsStream("/swagger.properties");
        try {
            prop.load(inputStream);
            return prop;
        } catch (IOException e) {
            throw new Error("missing swagger.properties file");
        }
    }

    private static Model convert(Class contentClass) {
        Model model;
        Annotation dataDefinition = contentClass.getAnnotation(DataDefinition.class);
        if (dataDefinition == null) {
            ModelImpl modelImpl = new ModelImpl();
            modelImpl = modelImpl.name(contentClass.getSimpleName());
            for (Field field: contentClass.getFields()) {
                if(field.isAnnotationPresent(Property.class)) {
                    modelImpl.addProperty(field.getName(), convert(field));
                }
            }
            model = modelImpl;
        } else {
            RefModel refModel = new RefModel(contentClass.getSimpleName());
            // TODO setProperties
            model = refModel;
        }
        return model;
    }

    private static io.swagger.models.properties.Property convert(Field field) {
        io.swagger.models.properties.Property property;
        Property propertyAnnoation = field.getAnnotation(Property.class);
        Class<?> fieldType = field.getType();
        if (fieldType.isPrimitive()) {
            // TODO setProperties
            IntegerProperty integerProperty = new IntegerProperty();
            property = integerProperty;
        } else {
            ObjectProperty objectProperty = new ObjectProperty();
            // TODO setProperties
            property = objectProperty;
        }
        return property;
    }

    public static void main(String[] args) {
        Swagger swagger = convert(new ModelBuilder().build());
        Json.prettyPrint(swagger);
    }
}
