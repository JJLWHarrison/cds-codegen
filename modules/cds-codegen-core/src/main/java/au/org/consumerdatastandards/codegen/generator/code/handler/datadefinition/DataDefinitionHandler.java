package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.shaded.commons.io.FilenameUtils;

import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import au.org.consumerdatastandards.codegen.model.DataDefinitionModel;
import au.org.consumerdatastandards.codegen.model.DataDefinitionModelField;
import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

public class DataDefinitionHandler extends AbstractHandler<DataDefinitionHandlerConfig> {
    private static final Logger LOG = LogManager.getLogger(DataDefinitionHandler.class);

    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof DataDefinitionHandlerConfig;
    }

    public List<DataDefinitionModel> collectDataDefinitions() {
        List<DataDefinitionModel> dataDefinitions = new ArrayList<DataDefinitionModel>();
        for (Class<?> definitionClass : codegenModel.getDataDefinitions()) {
            LOG.debug("Parsing data definition named: {}", definitionClass.getName());

            DataDefinitionModel oneDataDefinition = new DataDefinitionModel();
            oneDataDefinition.definitionName = definitionClass.getSimpleName();
            oneDataDefinition.packageName = definitionClass.getPackage().getName();
            oneDataDefinition.isEnum = definitionClass.isEnum();

            for (Annotation oneAnnotation : definitionClass.getAnnotations()) {
                // LOG.debug("Parsing annotation called {}",
                // oneAnnotation.annotationType().toString());
                if (oneAnnotation.annotationType().equals(DataDefinition.class)) {
                    DataDefinition thisDefinition = (DataDefinition) oneAnnotation;
                    oneDataDefinition.definitionDescription = thisDefinition.description().replaceAll("\n"," ");
                    Class<?>[] allOfClasses = thisDefinition.allOf();
                    if (allOfClasses.length > 0) {
                        oneDataDefinition.extendsOn = allOfClasses[0].getSimpleName();
                    }

                }

            }

            Field[] definitionFields = definitionClass.getDeclaredFields();
            for (Field oneField : definitionFields) {
                oneField.setAccessible(true);
                DataDefinitionModelField oneModelField = new DataDefinitionModelField();

                if (oneDataDefinition.isEnum) {
                    if (oneField.isEnumConstant()) {
                        oneModelField.name = oneField.getName();
                        oneDataDefinition.fieldList.add(oneModelField);
                    }

                } else {
                    oneModelField.name = oneField.getName();
                    if (oneField.getType().isAssignableFrom(List.class)) {
                        Class<?> innerType = (Class<?>) ((ParameterizedType) oneField.getGenericType())
                                .getActualTypeArguments()[0];
                        oneModelField.type = targetConfig.getTypeMapping("List", innerType.getSimpleName());
                    } else {
                        if (targetConfig.hasTypeMapping(oneField.getType().getSimpleName())) {
                            oneModelField.type = targetConfig.getTypeMapping(oneField.getType().getSimpleName());
                        } else {
                            oneModelField.type = oneField.getType().getSimpleName();
                        }
                    }

                    for (Annotation oneAnnotation : oneField.getAnnotations()) {
                        if (oneAnnotation.annotationType().equals(Property.class)) {
                            Property thisProperty = (Property) oneAnnotation;
                            oneModelField.description = thisProperty.description().replaceAll("\n"," ");
                            oneModelField.isRequired = thisProperty.required();
                            oneModelField.isId = thisProperty.isId();
                        }

                        if (oneAnnotation.annotationType().equals(CDSDataType.class)) {
                            CDSDataType thisDataType = (CDSDataType) oneAnnotation;
                            if (thisDataType.value().getFormat() != null) {
                                oneModelField.type = targetConfig
                                        .getTypeMapping(thisDataType.value().getFormat().getJavaType());
                            }

                            if (thisDataType.value().getPattern() != null) {
                                oneModelField.validationPattern = thisDataType.value().getPattern();
                            }

                            if (thisDataType.value().getMin() != null) {
                                oneModelField.minValue = thisDataType.value().getMin();
                            }

                            if (thisDataType.value().getMax() != null) {
                                oneModelField.maxValue = thisDataType.value().getMax();
                            }
                        }

                    }
                    oneDataDefinition.fieldList.add(oneModelField);
                }

                

            }

            dataDefinitions.add(oneDataDefinition);
        }
        return dataDefinitions;
    }

    @Override
    public void setConfig(AbstractHandlerConfig inputConfig) {
        config = (DataDefinitionHandlerConfig) inputConfig;
    }

    @Override
    public Class<?> getAbstractHandlerConfigClass() {
        return DataDefinitionHandlerConfig.class;
    }
    
    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException {
        List<DataDefinitionModel> dataDefinitions = collectDataDefinitions();
        for (DataDefinitionModel oneModel : dataDefinitions) {
            // We reparse the supplied handler config in the context of this particular data
            // definition model
            DataDefinitionHandlerConfig modelConfig = perModelConfig(oneModel);

            String templateName = oneModel.isEnum ? modelConfig.enumTemplate : modelConfig.modelTemplate;
            if(oneModel.isEnum && templateName.equals("null")) {
                LOG.debug("Skipping writing of file {}/{}/{}/{} on basis that target is Enum and no Enum template supplied",  options.getOutputPath(), modelConfig.baseDirectory, modelConfig.filePath, modelConfig.fileName);
            } else {
                LOG.debug("Writing file to {}/{}/{}/{} with template {}", options.getOutputPath(), modelConfig.baseDirectory, modelConfig.filePath, modelConfig.fileName, templateName);
                VelocityFile oneFile = new VelocityFile(modelConfig.fileName,
                        FilenameUtils.normalize(String.format("%s/%s/%s", options.getOutputPath(), modelConfig.baseDirectory, modelConfig.filePath)),
                        templateName, modelConfig, oneModel);
                velocityHelper.addFile(oneFile);
            }
        }

    }

}
