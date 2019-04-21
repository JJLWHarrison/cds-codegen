package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of the specific eligibility constraint for a discount
 */
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

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DiscountEligibilityType fromValue(String value) {
    for (DiscountEligibilityType b : DiscountEligibilityType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

