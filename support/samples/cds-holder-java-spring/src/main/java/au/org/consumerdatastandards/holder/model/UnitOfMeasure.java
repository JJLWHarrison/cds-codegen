package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The unit of measure that applies to the tierValueMinimum and tierValueMaximum values e.g. 'DOLLAR', 'MONTH' (in the case of term deposit tiers), 'PERCENT' (in the case of loan-to-value ratio or LVR)
 */
public enum UnitOfMeasure {
  
  DAY("DAY"),
  
  DOLLAR("DOLLAR"),
  
  MONTH("MONTH"),
  
  PERCENT("PERCENT");

  private String value;

  UnitOfMeasure(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static UnitOfMeasure fromValue(String value) {
    for (UnitOfMeasure b : UnitOfMeasure.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

