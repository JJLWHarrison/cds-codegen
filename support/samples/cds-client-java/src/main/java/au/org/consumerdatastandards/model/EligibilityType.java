/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The type of eligibility criteria described.  See the next section for an overview of valid values and their meaning
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

  public static EligibilityType fromValue(String value) {
    for (EligibilityType b : EligibilityType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<EligibilityType> {
    @Override
    public void write(final JsonWriter jsonWriter, final EligibilityType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public EligibilityType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return EligibilityType.fromValue(value);
    }
  }
}

