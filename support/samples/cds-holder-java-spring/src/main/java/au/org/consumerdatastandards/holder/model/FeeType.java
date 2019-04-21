package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of fee
 */
public enum FeeType {
  
  DEPOSIT("DEPOSIT"),
  
  EVENT("EVENT"),
  
  EXIT("EXIT"),
  
  PAYMENT("PAYMENT"),
  
  PERIODIC("PERIODIC"),
  
  PURCHASE("PURCHASE"),
  
  TRANSACTION("TRANSACTION"),
  
  UPFRONT("UPFRONT"),
  
  WITHDRAWAL("WITHDRAWAL");

  private String value;

  FeeType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static FeeType fromValue(String value) {
    for (FeeType b : FeeType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

