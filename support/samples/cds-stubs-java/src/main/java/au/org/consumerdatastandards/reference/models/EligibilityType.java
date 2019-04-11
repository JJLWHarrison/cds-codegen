/*
 * Consumer Data Standards
 * Client Reference Implementation for the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 
 * NOTE: This class is auto generated by the cds-codegen package
 * https://github.com/ConsumerDataStandardsAustralia/cds-codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.reference.models;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * The type of eligibility criteria described. See the next section for an
 * overview of valid values and their meaning
 */
@JsonAdapter(EligibilityType.Adapter.class)
public enum EligibilityType {

    BUSINESS("BUSINESS"),

    EMPLOYMENT_STATUS("EMPLOYMENT_STATUS"),

    MAX_AGE("MAX_AGE"),

    MIN_AGE("MIN_AGE"),

    MIN_INCOME("MIN_INCOME"),

    MIN_TURNOVER("MIN_TURNOVER"),

    NATURAL_PERSON("NATURAL_PERSON"),

    OTHER("OTHER"),

    PENSION_RECIPIENT("PENSION_RECIPIENT"),

    RESIDENCY_STATUS("RESIDENCY_STATUS"),

    STAFF("STAFF"),

    STUDENT("STUDENT");

    private String value;

    EligibilityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static EligibilityType fromValue(String text) {
        for (EligibilityType b : EligibilityType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public static class Adapter extends TypeAdapter<EligibilityType> {
        @Override
        public void write(final JsonWriter jsonWriter, final EligibilityType enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public EligibilityType read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return EligibilityType.fromValue(String.valueOf(value));
        }
    }
}
