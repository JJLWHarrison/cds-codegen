package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.interfaces.api.ModelInterface;
import au.org.consumerdatastandards.models.types.support.Endpoint;
import au.org.consumerdatastandards.models.types.support.EndpointResponse;
import au.org.consumerdatastandards.models.types.support.ModelDefinition;
import au.org.consumerdatastandards.models.types.support.Section;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Accepts a defined class then processes annotations and methods to produce a
 * data model.
 * 
 * @author stuart
 *
 */
public class ModelBuilder {
	
    private Logger logger = LogManager.getLogger(this.getClass());

	private final ModelInterface model;

	public ModelBuilder(ModelInterface inputModel) {
		this.model = inputModel;
	}
	
	public Map<String, Object> getModelForest() {
		Map<String,Object> modelMap = new HashMap<String,Object>();

		// Process sections
		modelMap.put("sections", getSectionForest(model.getSections()));
		modelMap.put("models", getModelForest((ArrayList<Map<String,Object>>) modelMap.get("sections")));
		
		return modelMap;
	}
	
	private List<Object> getModelForest(ArrayList<Map<String, Object>> sectionList) {
		Map<String,ModelDefinition> modelMap = new HashMap<String,ModelDefinition>();

		for (Map<String, Object> oneSection : sectionList) {
			List<Endpoint> myEndpoints = (ArrayList<Endpoint>) oneSection.get("endpoints");

			myEndpoints.forEach((oneEndpoint) -> {
				EndpointResponse[] responseList = oneEndpoint.responseList();
				for (EndpointResponse endpointResponse : responseList) {
					modelMap.putAll(getModelMap(endpointResponse.content()));
				}
			});
		}
		
		return Arrays.asList(modelMap.values());
	}
	
	private Map<String, ModelDefinition> getModelMap(Class content) {
		Map<String,ModelDefinition> modelMap = new HashMap<String,ModelDefinition>();
		
		logger.info("Parsing for {}", content);
		Method[] methodList = content.getDeclaredMethods();
		for (Method method : methodList) {
			String modelName = method.getReturnType().getCanonicalName();
			Map<String, Object> attributeMap = new HashMap<>();

			if (modelMap.containsKey(modelName)) {
				logger.info("Duplicate model definition found for {}", modelName);
			} else if (method.getReturnType().isPrimitive() || method.getReturnType().equals(String.class) || method.getReturnType().isEnum()) {
				logger.info("Writing primitive variable type for: {}", modelName);
				attributeMap.put(method.getName(), method.getReturnType().getSimpleName());
			} else {
				logger.info("The response list says: {}", method.getReturnType());
				//modelMap.put(modelName, getModelMap(methodList[k].getReturnType()));
			}
		}
		
		return modelMap;		
	}

	private ArrayList<Map<String,Object>> getSectionForest(Class[] sections) {
		ArrayList<Map<String,Object>> sectionList = new ArrayList<Map<String,Object>>();

        for (Class section : sections) {
            sectionList.add(getSection(section));
        }
		
		return sectionList;
		
	}

	private Map<String,Object> getSection(Class inputSection) {
		
		Map<String,Object> oneSection = new HashMap<String,Object>();
		List<Endpoint> myEndpoints = new ArrayList<Endpoint>();

		// Pull the section class name
		oneSection.put("model", inputSection.getName());

		// Pull the section name from annotation
		oneSection.put("definition", inputSection.getAnnotation(Section.class));
		
		// Now build methods
		Method[] fields = inputSection.getDeclaredMethods();
		for (int j = 0; j < Array.getLength(fields); j++) {
			System.out.println("Method: " + fields[j].toString());
			Endpoint myEndpoint = getEndpoint(fields[j]);
			if(myEndpoint != null) {
				myEndpoints.add(myEndpoint);
			}
		}
		
		oneSection.put("endpoints", myEndpoints);
		
		return oneSection;
		
	}
	
	private Endpoint getEndpoint(Method method) {
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(Endpoint.class)) {
				return (Endpoint) annotation;
			}
		}

        logger.error("Endpoint annotation for " + method.getName() + " not found");
		return null;
	}
	
}


