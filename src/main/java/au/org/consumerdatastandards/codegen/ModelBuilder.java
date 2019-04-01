package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.model.*;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.Section;
import au.org.consumerdatastandards.support.data.DataDefinition;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * APIModel builder
 *
 * @author stuart, fyang1024
 */
public class ModelBuilder {

    private final static String BASE_PACKAGE = "au.org.consumerdatastandards.api";

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
            sectionModel.setEndpointModels(getEndpointModels(sectionClass));
            sectionModels.add(sectionModel);
        }
        return sectionModels;
    }

    private List<EndpointModel> getEndpointModels(Class<?> sectionClass) {

        List<EndpointModel> endpointModels = new ArrayList<>();
        for(Method method : sectionClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Endpoint.class)) {
                Endpoint endpoint = method.getAnnotation(Endpoint.class);
                EndpointModel endpointModel = new EndpointModel(endpoint);
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    if (parameter.isAnnotationPresent(Param.class)) {
                        endpointModel.addParamModel(new ParamModel(parameter));
                    }
                }
                endpointModels.add(endpointModel);
            }
        }
        return endpointModels;
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


