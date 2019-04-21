package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of eligibility criteria described.  See the next section for an overview of valid values and their meaning
 */
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

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EligibilityType fromValue(String value) {
    for (EligibilityType b : EligibilityType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

