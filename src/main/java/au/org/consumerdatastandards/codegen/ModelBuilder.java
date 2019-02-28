package au.org.consumerdatastandards.codegen;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import au.org.consumerdatastandards.interfaces.api.ModelInterface;
import au.org.consumerdatastandards.models.types.support.Endpoint;
import au.org.consumerdatastandards.models.types.support.EndpointResponse;
import au.org.consumerdatastandards.models.types.support.ModelDefinition;
import au.org.consumerdatastandards.models.types.support.Section;

/**
 * Accepts a defined class then processes annotations and methods to produce a
 * data model.
 * 
 * @author stuart
 *
 */
public class ModelBuilder {
	
    public Logger logger = LogManager.getLogger(ModelBuilder.class);

	ModelInterface model;

	public ModelBuilder(ModelInterface inputModel) {
		this.model = inputModel;
	}
	
	public Map<String, Object> getModelForest() {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		/**
		 * Process sections
		 */
		modelMap.put("sections", getSectionForest(model.getSections()));
		modelMap.put("models", getModelForest((ArrayList<Map<String,Object>>) modelMap.get("sections")));
		
		return modelMap;
	}
	
	private List<Object> getModelForest(ArrayList<Map<String, Object>> sectionList) {
		Map<String,ModelDefinition> modelMap = new HashMap<String,ModelDefinition>();
		
		for(int i = 0; i < sectionList.size(); i++) {
			Map<String,Object> oneSection = sectionList.get(i);
			
			ArrayList<Endpoint> myEndpoints = (ArrayList<Endpoint>) oneSection.get("endpoints");
			
			myEndpoints.forEach((oneEndpoint) -> {
				EndpointResponse[] responseList = oneEndpoint.responseList();
				for(int j = 0; j < responseList.length; j++) {
					modelMap.putAll(getModelMap(responseList[j].content()));
				}
			});
		}
		
		return List.copyOf(modelMap.values());
		
	}
	
	private Map<String, ModelDefinition> getModelMap(Class content) {
		Map<String,ModelDefinition> modelMap = new HashMap<String,ModelDefinition>();
		
		System.out.println("Parsing for " + content);
		Method[] methodList = content.getDeclaredMethods();
		for(int k = 0; k < methodList.length; k++) {
			String modelName = methodList[k].getReturnType().getCanonicalName();
			Map<String,Object> attributeMap = new HashMap<String,Object>();
			
			if(modelMap.containsKey(modelName)) {
				System.out.println(String.format("Duplicate model definition found for %s", modelName));
				continue;
			} else if(methodList[k].getReturnType().isPrimitive() || methodList[k].getReturnType().equals(String.class) || methodList[k].getReturnType().isEnum() ) {
				System.out.println(String.format("Writing primitive variable type for: %s", modelName));
				attributeMap.put(methodList[k].getName(), methodList[k].getReturnType().getSimpleName());
				continue;
			} else {
				
				System.out.println("The response list says: " + methodList[k].getReturnType());
				//modelMap.put(modelName, getModelMap(methodList[k].getReturnType()));
			}
		}
		
		return modelMap;		
	}

	private ArrayList<Map<String,Object>> getSectionForest(Class[] sections) {
		ArrayList<Map<String,Object>> sectionList = new ArrayList<Map<String,Object>>();
		
		for(int i = 0; i < sections.length; i++) {
			sectionList.add(getSection(sections[i]));
		}
		
		return sectionList;
		
	}

	private Map<String,Object> getSection(Class inputSection) {
		
		Map<String,Object> oneSection = new HashMap<String,Object>();
		ArrayList<Endpoint> myEndpoints = new ArrayList<Endpoint>();
		
		/**
		 * Pull the section class name
		 */
		oneSection.put("model", inputSection.getName());
		
		/**
		 * Pull the section name from annotation
		 */
		oneSection.put("definition", inputSection.getAnnotation(Section.class));
		
		/**
		 * Now build methods
		 */
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
		for(int k = 0; k < annotations.length; k++) {
			if(annotations[k].annotationType().equals(Endpoint.class)) {
				Endpoint myAnnotation = (Endpoint) annotations[k];
				return myAnnotation;
			}
		}

        logger.error("Endpoint annotation for " + method.getName() + " not found");
		return null;
	}
	
}


