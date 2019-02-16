package au.org.consumerdatastandards.cge;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.org.consumerdatastandards.interfaces.api.ModelInterface;
import au.org.consumerdatastandards.models.types.support.Endpoint;

/**
 * Accepts a defined class then processes annotations and methods to produce a
 * data model.
 * 
 * @author stuart
 *
 */
public class ModelBuilder {

	ModelInterface model;

	public ModelBuilder(ModelInterface inputModel) {
		this.model = inputModel;
	}
	
	public Map<String, Object> getModelForest() {
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		/**
		 * Process sections
		 */
		modelMap.put("sections", dumpSections(model.getSections()));
		
	}
	
	
	private ArrayList<Object> dumpSections(Class[] sections) {
		ArrayList<Object> sectionList = new ArrayList<Object>();
		
		for(int i = 0; i < sections.length; i++) {
			sectionList.add(getSection(sections[i]));
		}
		
		return sectionList;
		
	}

	private Object getSection(Class class1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Object> dump(ArrayList<Object> arrayList, Object inputObject) {
		if(inputObject instanceof Class) {
			return dumpClass(arrayList, (Class)inputObject);
		} else {
			return dump(arrayList, inputObject.getClass());
		}
	}

	public static HashMap dumpClass(HashMap hashMap, Class inputClass) {
		
		System.out.println("Dumping: " + inputClass.getName());

		Method[] fields = inputClass.getDeclaredMethods();
		List<Object> myEndpointList = new ArrayList<Object>();
		for (int j = 0; j < Array.getLength(fields); j++) {
			System.out.println("Method: " + fields[j].toString());
						
			Annotation[] annotations = fields[j].getAnnotations();
			List<Object> myAnnotationsList = new ArrayList<Object>();
			for(int k = 0; k < annotations.length; k++) {
				if(annotations[k].annotationType().equals(au.org.consumerdatastandards.models.types.support.Endpoint.class)) {
					System.out.println("Endpoint Annotation found!");
					au.org.consumerdatastandards.models.types.support.Endpoint myAnnotation = (Endpoint) annotations[k];
					myAnnotationsList.add(myAnnotation);
					dumpClass(myAnnotationsList, myAnnotation.getClass());
				} else {
					System.out.println("Unknown annotation type: " + annotations[k].annotationType().getName());
				}
			}
			
			myEndpointList.add(myAnnotationsList);
		}
		
		hashMap.put("endpoints", myEndpointList);
		return hashMap;
	}
}
