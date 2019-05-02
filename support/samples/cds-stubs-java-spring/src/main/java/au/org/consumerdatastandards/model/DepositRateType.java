package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of rate (base, bonus, etc). See the next section for an overview of valid values and their meaning
 */
public enum DepositRateType {
  
  BONUS("BONUS"),
  
  BUNDLE_BONUS("BUNDLE_BONUS"),
  
  FIXED("FIXED"),
  
  FLOATING("FLOATING"),
  
  INTRODUCTORY("INTRODUCTORY"),
  
  MARKET_LINKED("MARKET_LINKED"),
  
  VARIABLE("VARIABLE");

  private String value;

  DepositRateType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DepositRateType fromValue(String value) {
    for (DepositRateType b : DepositRateType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

