package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of constraint described.  See the next section for an overview of valid values and their meaning
 */
public enum ConstraintType {
  
  MAX_BALANCE("MAX_BALANCE"),
  
  MAX_LIMIT("MAX_LIMIT"),
  
  MIN_BALANCE("MIN_BALANCE"),
  
  MIN_LIMIT("MIN_LIMIT"),
  
  OPENING_BALANCE("OPENING_BALANCE");

  private String value;

  ConstraintType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ConstraintType fromValue(String value) {
    for (ConstraintType b : ConstraintType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

