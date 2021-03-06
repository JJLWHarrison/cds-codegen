package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.api.common.responses.PaginatedResponse;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.model.APIModel;
import au.org.consumerdatastandards.codegen.model.DataOperationModel;
import au.org.consumerdatastandards.codegen.model.EndpointModel;
import au.org.consumerdatastandards.codegen.model.ParamModel;
import au.org.consumerdatastandards.codegen.model.SectionModel;
import au.org.consumerdatastandards.codegen.util.CustomAttributesUtil;
import au.org.consumerdatastandards.support.DataAttribute;
import au.org.consumerdatastandards.support.DataOperation;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.Section;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;

/**
 * APIModel builder
 *
 * @author csirostu, fyang1024
 */
public class ModelBuilder {

    private final static String BASE_PACKAGE = "au.org.consumerdatastandards.api";
    private static final Logger LOG = LogManager.getLogger(ModelBuilder.class);


    private Options options;

    public ModelBuilder(Options options) {
        this.options = options;
    }

    public APIModel build() {

        APIModel apiModel = new APIModel();
        Reflections reflections = new Reflections(BASE_PACKAGE);
        Set<Class<?>> sectionClasses = reflections.getTypesAnnotatedWith(Section.class);
        for (Class<?> sectionClass : sectionClasses) {
            Section section = sectionClass.getAnnotation(Section.class);
            if (options.isSectionIncluded(section.name())) {
                apiModel.add(buildSectionModel(section, sectionClass));
            }
        }
        return apiModel;
    }

    private SectionModel buildSectionModel(Section section, Class<?> sectionClass) {
        SectionModel sectionModel = new SectionModel(section);
        sectionModel.setInterfaceName(sectionClass.getSimpleName());
        sectionModel.setPackageName(sectionClass.getPackage().getName());
        CustomAttributesUtil.addCustomAttributes(sectionClass, sectionModel);
        for (Method method : MethodUtils.getMethodsListWithAnnotation(sectionClass, Endpoint.class, true, true)) {
            EndpointModel endpointModel = buildEndpointModel(method);
            sectionModel.add(endpointModel);
        }
        return sectionModel;
    }

    private EndpointModel buildEndpointModel(Method method) {
        Endpoint endpoint = method.getAnnotation(Endpoint.class);
        EndpointModel endpointModel = new EndpointModel(endpoint);
        // LOG.debug("Default response for {} is {}", method.getName(), method.getReturnType().getSimpleName());
        endpointModel.setDefaultResponse(method.getReturnType().getSimpleName());
        CustomAttributesUtil.addCustomAttributes(method, endpointModel);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(Param.class)) {
                ParamModel paramModel = new ParamModel(parameter);
                CustomAttributesUtil.addCustomAttributes(parameter, paramModel);
                endpointModel.addParamModel(paramModel);
            }
        }
        
        if(method.isAnnotationPresent(DataOperation.class)) {
            DataOperation dataOperation = method.getAnnotation(DataOperation.class);
            DataOperationModel operationModel = new DataOperationModel(dataOperation.type(), dataOperation.targetModel().getSimpleName());
            for(DataAttribute oneAttribute : dataOperation.attributeMapping()) {
                operationModel.addAttributeModel(oneAttribute.requestParameter(), oneAttribute.required(), oneAttribute.matchMethod());
            }
            endpointModel.setDataOperationModel(operationModel);
        }
        
        return endpointModel;
    }
}


