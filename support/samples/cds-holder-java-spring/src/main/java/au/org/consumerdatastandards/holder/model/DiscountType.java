package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of discount. See the next section for an overview of valid values and their meaning
 */
public enum DiscountType {
  
  BALANCE("BALANCE"),
  
  DEPOSITS("DEPOSITS"),
  
  ELIGIBILITY_ONLY("ELIGIBILITY_ONLY"),
  
  FEE_CAP("FEE_CAP"),
  
  PAYMENTS("PAYMENTS");

  private String value;

  DiscountType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DiscountType fromValue(String value) {
    for (DiscountType b : DiscountType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

