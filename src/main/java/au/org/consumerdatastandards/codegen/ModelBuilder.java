package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.interfaces.api.ModelInterface;
import au.org.consumerdatastandards.models.types.support.Endpoint;
import au.org.consumerdatastandards.models.types.support.EndpointResponse;
import au.org.consumerdatastandards.models.types.support.ModelDefinition;
import au.org.consumerdatastandards.models.types.support.Section;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Accepts a defined class then processes annotations and methods to produce a
 * data model.
 *
 * @author stuart
 */
public class ModelBuilder {

    private static final String SECTIONS = "sections";
    private static final String MODELS = "models";
    private static final String ENDPOINTS = "endpoints";
    private static final String MODEL = "model";
    private static final String DEFINITION = "definition";

    private Logger logger = LogManager.getLogger(this.getClass());

    private final ModelInterface model;

    public ModelBuilder(ModelInterface inputModel) {
        this.model = inputModel;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getModelForest() {
        Map<String, Object> modelMap = new HashMap<>();

        // Process sections
        modelMap.put(SECTIONS, getSectionForest(model.getSections()));
        modelMap.put(MODELS, getModelForest((List<Map<String, Object>>) modelMap.get(SECTIONS)));

        return modelMap;
    }

    @SuppressWarnings("unchecked")
    private List<Object> getModelForest(List<Map<String, Object>> sectionList) {
        Map<String, ModelDefinition> modelMap = new HashMap<>();

        for (Map<String, Object> oneSection : sectionList) {
            List<Endpoint> myEndpoints = (ArrayList<Endpoint>) oneSection.get(ENDPOINTS);

            myEndpoints.forEach((oneEndpoint) -> {
                EndpointResponse[] responseList = oneEndpoint.responseList();
                for (EndpointResponse endpointResponse : responseList) {
                    modelMap.putAll(getModelMap(endpointResponse.content()));
                }
            });
        }

        return Collections.singletonList(modelMap.values());
    }

    private Map<String, ModelDefinition> getModelMap(Class content) {
        Map<String, ModelDefinition> modelMap = new HashMap<>();

        logger.info("Parsing for {}", content);
        Method[] declaredMethods = content.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Class<?> returnType = method.getReturnType();
            String modelName = returnType.getCanonicalName();
            Map<String, Object> attributeMap = new HashMap<>();
            if (returnType.isPrimitive() || returnType.equals(String.class) || returnType.isEnum()) {
                logger.info("Writing primitive variable type for: {}", modelName);
                attributeMap.put(method.getName(), returnType.getSimpleName());
            } else {
                logger.info("The response list says: {}", returnType);
                //modelMap.put(modelName, getModelMap(declaredMethods[k].getReturnType()));
            }
        }

        return modelMap;
    }

    private List<Map<String, Object>> getSectionForest(Class[] sections) {

        List<Map<String, Object>> sectionList = new ArrayList<>();
        for (Class section : sections) {
            sectionList.add(getSection(section));
        }

        return sectionList;
    }

    private Map<String, Object> getSection(Class inputSection) {

        Map<String, Object> oneSection = new HashMap<>();
        List<Endpoint> myEndpoints = new ArrayList<>();

        // Pull the section class name
        oneSection.put(MODEL, inputSection.getName());

        // Pull the section name from annotation
        oneSection.put(DEFINITION, inputSection.getAnnotation(Section.class));

        // Now build methods
        Method[] declaredMethods = inputSection.getDeclaredMethods();
        for (Method method : declaredMethods) {
            logger.info("Method: {}", method);
            Endpoint myEndpoint = getEndpoint(method);
            if (myEndpoint != null) {
                myEndpoints.add(myEndpoint);
            }
        }

        oneSection.put(ENDPOINTS, myEndpoints);

        return oneSection;
    }

    private Endpoint getEndpoint(Method method) {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(Endpoint.class)) {
                return (Endpoint) annotation;
            }
        }

        logger.error("Endpoint annotation for {} not found", method.getName());
        return null;
    }

}


