package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.data.IntegerRange;
import au.org.consumerdatastandards.support.data.Pattern;
import au.org.consumerdatastandards.support.data.StringFormat;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.Parameter;

public class ParamModel {

    private Param param;

    private Class paramDataType;

    private StringFormat stringFormat;

    private Pattern pattern;

    private IntegerRange integerRange;

    public ParamModel(Parameter parameter) {
        this.param = parameter.getAnnotation(Param.class);
        this.paramDataType = parameter.getType();
        this.stringFormat = parameter.getAnnotation(StringFormat.class);
        this.pattern = parameter.getAnnotation(Pattern.class);
        this.integerRange = parameter.getAnnotation(IntegerRange.class);
    }

    public StringFormat getStringFormat() {
        return stringFormat;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public IntegerRange getIntegerRange() {
        return integerRange;
    }

    public Param getParam() {
        return param;
    }

    public Class getParamDataType() {
        return paramDataType;
    }

    public boolean isSimple() {
        return ClassUtils.isPrimitiveOrWrapper(paramDataType)
                || String.class.equals(paramDataType)
                || Number.class.isAssignableFrom(paramDataType);
    }

    public String generateRef() {
        return "Param" + paramDataType.getSimpleName();
    }
}
