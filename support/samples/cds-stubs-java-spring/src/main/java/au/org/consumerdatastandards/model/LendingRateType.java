package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of rate (fixed, variable, etc). See the next section for an overview of valid values and their meaning
 */
public enum LendingRateType {
  
  BUNDLE_DISCOUNT_FIXED("BUNDLE_DISCOUNT_FIXED"),
  
  BUNDLE_DISCOUNT_VARIABLE("BUNDLE_DISCOUNT_VARIABLE"),
  
  CASH_ADVANCE("CASH_ADVANCE"),
  
  DISCOUNT("DISCOUNT"),
  
  FIXED("FIXED"),
  
  FLOATING("FLOATING"),
  
  INTRODUCTORY("INTRODUCTORY"),
  
  MARKET_LINKED("MARKET_LINKED"),
  
  PENALTY("PENALTY"),
  
  PURCHASE("PURCHASE"),
  
  VARIABLE("VARIABLE");

  private String value;

  LendingRateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static LendingRateType fromValue(String value) {
    for (LendingRateType b : LendingRateType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

