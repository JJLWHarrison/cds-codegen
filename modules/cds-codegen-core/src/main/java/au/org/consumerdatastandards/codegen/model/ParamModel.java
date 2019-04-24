package au.org.consumerdatastandards.codegen.model;

import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.IntegerRange;
import au.org.consumerdatastandards.support.data.Pattern;
import au.org.consumerdatastandards.support.data.StringFormat;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.apache.logging.log4j.util.Strings;

public class ParamModel extends ModelBase implements Comparable<ParamModel> {

    private Param param;

    private String name;

    private Class<?> paramDataType;

    private CDSDataType cdsDataType;

    private StringFormat stringFormat;

    private Pattern pattern;

    private IntegerRange integerRange;
    
    private List<String> allowableValues;

    public ParamModel(Parameter parameter) {
        this.param = parameter.getAnnotation(Param.class);
        this.name = this.param.name();
        this.paramDataType = parameter.getType();
        this.cdsDataType = parameter.getAnnotation(CDSDataType.class);
        this.stringFormat = parameter.getAnnotation(StringFormat.class);
        this.pattern = parameter.getAnnotation(Pattern.class);
        this.integerRange = parameter.getAnnotation(IntegerRange.class);
        
        // If the type is an enum, populate allowedValues
        if(parameter.getType().isEnum()) {
            Object[] enumConstants = parameter.getType().getEnumConstants();
            allowableValues = new ArrayList<String>();
            for (Object enumConstant : enumConstants) {
                allowableValues.add(((Enum<?>) enumConstant).name());
            }            
        }
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

    public Class<?> getParamDataType() {
        return paramDataType;
    }

    public CDSDataType getCDSDataType() {
        return cdsDataType;
    }

    @Override
    public int compareTo(ParamModel paramModel) {

        return name.compareTo(paramModel.name);
    }
    
    public String getName() {
        return name;
    }
    
    public String getCamelCaseName() {
        return CaseUtils.toCamelCase(param.name(), false, new char[]{'-'});
    }
    
    public List<String> getAllowableValues() {
        return allowableValues;
    }
    
    public boolean hasAllowableValues() {
        return allowableValues != null && !allowableValues.isEmpty();
    }
    
    
}
