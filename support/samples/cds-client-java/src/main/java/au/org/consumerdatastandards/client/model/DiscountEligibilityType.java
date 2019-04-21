/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The type of the specific eligibility constraint for a discount
 */
@JsonAdapter(DiscountEligibilityType.Adapter.class)
public enum DiscountEligibilityType {
  
  BUSINESS("BUSINESS"),
  
  EMPLOYMENT_STATUS("EMPLOYMENT_STATUS"),
  
  INTRODUCTORY("INTRODUCTORY"),
  
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

  DiscountEligibilityType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static DiscountEligibilityType fromValue(String value) {
    for (DiscountEligibilityType b : DiscountEligibilityType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<DiscountEligibilityType> {
    @Override
    public void write(final JsonWriter jsonWriter, final DiscountEligibilityType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public DiscountEligibilityType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return DiscountEligibilityType.fromValue(value);
    }
  }
}

