package au.org.consumerdatastandards.cge;

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
		
		
		return modelMap;
	}
	
	
	private ArrayList<Object> getSectionForest(Class[] sections) {
		ArrayList<Object> sectionList = new ArrayList<Object>();
		
		for(int i = 0; i < sections.length; i++) {
			sectionList.add(getSection(sections[i]));
		}
		
		return sectionList;
		
	}

	private Map<String,Object> getSection(Class inputSection) {
		
		Map<String,Object> oneSection = new HashMap<String,Object>();
		ArrayList<Object> myEndpoints = new ArrayList<Object>();
		
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
			Object myEndpoint = getEndpoint(fields[j]);
			if(myEndpoint != null) {
				myEndpoints.add(myEndpoint);
			}
			
		}
		
		oneSection.put("endpoints", myEndpoints);
		
		return oneSection;
		
	}
	
	
		
		
	private Object getEndpoint(Method method) {
		Annotation[] annotations = method.getAnnotations();
		for(int k = 0; k < annotations.length; k++) {
			if(annotations[k].annotationType().equals(au.org.consumerdatastandards.models.types.support.Endpoint.class)) {
				au.org.consumerdatastandards.models.types.support.Endpoint myAnnotation = (Endpoint) annotations[k];
				return myAnnotation;
			}
		}
		
		logger.error("Endpoint for " + method.getName() + " not found");
		return null;
	}
}
