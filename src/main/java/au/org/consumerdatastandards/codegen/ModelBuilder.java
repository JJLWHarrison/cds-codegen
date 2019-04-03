package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.model.*;
import au.org.consumerdatastandards.codegen.util.CustomAttributesUtil;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.Section;
import au.org.consumerdatastandards.support.data.DataDefinition;
import org.apache.commons.lang3.reflect.MethodUtils;
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
        for (Class<?> sectionClass : sectionClasses) {
            Section section = sectionClass.getAnnotation(Section.class);
            SectionModel sectionModel = new SectionModel(section);
            CustomAttributesUtil.addCustomAttributes(sectionClass, sectionModel);
            sectionModel.setEndpointModels(getEndpointModels(sectionClass));
            sectionModels.add(sectionModel);
        }
        return sectionModels;
    }

    private List<EndpointModel> getEndpointModels(Class<?> sectionClass) {

        List<EndpointModel> endpointModels = new ArrayList<>();
        for (Method method : MethodUtils.getMethodsListWithAnnotation(sectionClass, Endpoint.class, true, true)) {
            Endpoint endpoint = method.getAnnotation(Endpoint.class);
            EndpointModel endpointModel = new EndpointModel(endpoint);
            CustomAttributesUtil.addCustomAttributes(method, endpointModel);
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(Param.class)) {
                    ParamModel paramModel = new ParamModel(parameter);
                    CustomAttributesUtil.addCustomAttributes(parameter, paramModel);
                    endpointModel.addParamModel(paramModel);
                }
            }
            endpointModels.add(endpointModel);
        }
        return endpointModels;
    }

    private List<DataDefinitionModel> buildDataDefinitionModels() {

        List<DataDefinitionModel> dataDefinitionModels = new ArrayList<>();
        Reflections reflections = new Reflections(BASE_PACKAGE);
        Set<Class<?>> dataDefinitionClasses = reflections.getTypesAnnotatedWith(DataDefinition.class);
        for (Class<?> dataDefinitionClass : dataDefinitionClasses) {
            DataDefinition dataDefinition = dataDefinitionClass.getAnnotation(DataDefinition.class);
            DataDefinitionModel dataDefinitionModel = new DataDefinitionModel(dataDefinition, dataDefinitionClass);
            CustomAttributesUtil.addCustomAttributes(dataDefinitionClass, dataDefinitionModel);
            dataDefinitionModels.add(dataDefinitionModel);
        }
        return dataDefinitionModels;
    }
}


