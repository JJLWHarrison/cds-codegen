package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * When loan payments are due to be paid within each period. The investment benefit of earlier payments affect the rate that can be offered
 */
public enum InterestPaymentDue {
  
  ADVANCE("ADVANCE"),
  
  ARREARS("ARREARS");

  private String value;

  InterestPaymentDue(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static InterestPaymentDue fromValue(String value) {
    for (InterestPaymentDue b : InterestPaymentDue.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

