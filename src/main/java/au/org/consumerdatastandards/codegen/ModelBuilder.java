package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.DataDefinitionModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.Section;
import au.org.consumerdatastandards.support.data.DataDefinition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.*;

/**
 * APIModel builder
 *
 * @author stuart, fyang1024
 */
public class ModelBuilder {

    private final static String BASE_PACKAGE = "au.org.consumerdatastandards.api";

    private Logger logger = LogManager.getLogger(this.getClass());

    public APIModel build() {
        APIModel apiModel = new APIModel();
        apiModel.setSectionModels(buildSectionModels());
        apiModel.setDataDefinitionModels(buildDataDefinitionModels());
        return apiModel;
    }

    private List<SectionModel> buildSectionModels() {

        List<SectionModel> sectionModels = new ArrayList<>();
        Reflections reflections = new Reflections(BASE_PACKAGE);
        Set<Class<?>> sectionClasses = reflections.getTypesAnnotatedWith(Section.class);
        for(Class<?> sectionClass : sectionClasses) {
            Section section = sectionClass.getAnnotation(Section.class);
            SectionModel sectionModel = new SectionModel(section);
            sectionModel.setEndpoints(getEndpoints(sectionClass));
            sectionModels.add(sectionModel);
        }
        return sectionModels;
    }

    private List<Endpoint> getEndpoints(Class<?> sectionClass) {

        List<Endpoint> endpoints = new ArrayList<>();
        for(Method method : sectionClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Endpoint.class)) {
                Endpoint endpoint = method.getAnnotation(Endpoint.class);
                endpoints.add(endpoint);
            }
        }
        return endpoints;
    }

    private List<DataDefinitionModel> buildDataDefinitionModels() {

        List<DataDefinitionModel> dataDefinitionModels = new ArrayList<>();
        Reflections reflections = new Reflections(BASE_PACKAGE);
        Set<Class<?>> dataDefinitionClasses = reflections.getTypesAnnotatedWith(DataDefinition.class);
        for(Class<?> dataDefinitionClass: dataDefinitionClasses) {
            dataDefinitionModels.add(new DataDefinitionModel(dataDefinitionClass));
        }
        return dataDefinitionModels;
    }
}


