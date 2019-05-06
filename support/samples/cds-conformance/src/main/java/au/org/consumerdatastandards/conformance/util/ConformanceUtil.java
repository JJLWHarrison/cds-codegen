package au.org.consumerdatastandards.conformance.util;

import au.org.consumerdatastandards.codegen.util.ReflectionUtil;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.cglib.beans.BeanGenerator;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;


public class ConformanceUtil {

    public static void checkAgainstModel(Object data, Class<?> model, List<String> errors)  {
        List<Field> properties = FieldUtils.getFieldsListWithAnnotation(model, Property.class);
        for (Field modelField : properties) {
            Field dataField = FieldUtils.getField(data.getClass(), modelField.getName(), true);
            dataField.setAccessible(true);
            Object dataFieldValue;
            try {
                dataFieldValue = dataField.get(data);
            } catch (IllegalAccessException e) {
                throw new Error(e); // should never happen
            }
            if (modelField.getAnnotation(Property.class).required() && dataFieldValue == null) {
                errors.add( "Required field " + modelField.getName() + " has NULL value");
            }
            Class<?> modelFieldType = modelField.getType();
            if (modelFieldType.isArray()) {
                if (modelFieldType.getComponentType().isAnnotationPresent(DataDefinition.class)
                    && dataFieldValue != null
                    && Array.getLength(dataFieldValue) > 0) {
                    Object[] values = unpack(dataFieldValue);
                    for (Object value : values) {
                        checkAgainstModel(value, modelFieldType.getComponentType(), errors);
                    }
                }
            } else if (ReflectionUtil.isSetOrList(modelFieldType)) {
                Class<?> itemType = ReflectionUtil.getItemType(modelFieldType, modelField.getGenericType());
                if (itemType.isAnnotationPresent(DataDefinition.class)
                    && dataFieldValue != null && !((Collection) dataFieldValue).isEmpty()) {
                    for (Object value : (Collection) dataFieldValue) {
                        checkAgainstModel(value, itemType, errors);
                    }
                }
            } if (dataFieldValue != null && modelFieldType.isAnnotationPresent(DataDefinition.class)) {
                checkAgainstModel(dataFieldValue, modelFieldType, errors);
            }
        }

    }

    static Class<?> combine(Class<?> primaryClass, Class<?>[] allOf) {

        final BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.setNamingPolicy((s, s1, o, predicate) -> primaryClass.getName()+"$Generated");
        addProperties(beanGenerator, primaryClass);
        for (Class<?> clazz: allOf) {
            addProperties(beanGenerator, clazz);
        }
        return (Class<?>) beanGenerator.createClass();
    }


    private static void addProperties(BeanGenerator beanGenerator, Class<?> clazz) {
        Field[] allFields = FieldUtils.getAllFields(clazz);
        for(Field field: allFields) {
            beanGenerator.addProperty(field.getName(), getFieldType(field));
        }
    }

    private static Class<?> getFieldType(Field field) {
        if (ReflectionUtil.isSetOrList(field.getType())) {
            Class<?> itemType = ReflectionUtil.getItemType(field.getType(), field.getGenericType());
            return Array.newInstance(itemType, 0).getClass();
        }
        return field.getType();
    }


    public static Object[] unpack(Object array) {
        Object[] values = new Object[Array.getLength(array)];
        for (int i = 0; i < values.length; i++)
            values[i] = Array.get(array, i);
        return values;
    }
}
