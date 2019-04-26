package au.org.consumerdatastandards.conformance.util;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public class ReflectionUtil {

    public static boolean isSetOrList(Class<?> type) {

        return Set.class.isAssignableFrom(type) || List.class.isAssignableFrom(type);
    }

    public static Class<?> getItemType(Class<?> type, Type genericType) {

        if (type.isArray()) {
            return type.getComponentType();
        }
        if (genericType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            return (Class<?>) fieldArgTypes[0];
        }
        return Object.class;
    }

    public static Object[] unpack(Object array) {
        Object[] values = new Object[Array.getLength(array)];
        for (int i = 0; i < values.length; i++)
            values[i] = Array.get(array, i);
        return values;
    }
}
