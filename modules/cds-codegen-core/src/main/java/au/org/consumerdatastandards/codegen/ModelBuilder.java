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

    private ModelBuilderOptions options;

    public ModelBuilder(ModelBuilderOptions options) {
        this.options = options;
    }

    public APIModel build() {
        APIModel apiModel = new APIModel();
        apiModel.setSectionModels(buildSectionModels());
        return apiModel;
    }

    private List<SectionModel> buildSectionModels() {

        List<SectionModel> sectionModels = new ArrayList<>();
        Reflections reflections = new Reflections(BASE_PACKAGE);
        Set<Class<?>> sectionClasses = reflections.getTypesAnnotatedWith(Section.class);
        for (Class<?> sectionClass : sectionClasses) {
            Section section = sectionClass.getAnnotation(Section.class);
            if (options.isSectionIncluded(section.name())) {
                SectionModel sectionModel = new SectionModel(section);
                CustomAttributesUtil.addCustomAttributes(sectionClass, sectionModel);
                sectionModel.setEndpointModels(getEndpointModels(sectionClass));
                sectionModels.add(sectionModel);
            }
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
}


