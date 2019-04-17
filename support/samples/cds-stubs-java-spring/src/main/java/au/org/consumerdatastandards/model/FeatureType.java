package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of feature described
 */
public enum FeatureType {
  
  ADDITIONAL_CARDS("ADDITIONAL_CARDS"),
  
  BALANCE_TRANSFERS("BALANCE_TRANSFERS"),
  
  BILL_PAYMENT("BILL_PAYMENT"),
  
  BONUS_REWARDS("BONUS_REWARDS"),
  
  CARD_ACCESS("CARD_ACCESS"),
  
  COMPLEMENTARY_PRODUCT_DISCOUNTS("COMPLEMENTARY_PRODUCT_DISCOUNTS"),
  
  DIGITAL_BANKING("DIGITAL_BANKING"),
  
  DIGITAL_WALLET("DIGITAL_WALLET"),
  
  DONATE_INTEREST("DONATE_INTEREST"),
  
  FREE_TXNS("FREE_TXNS"),
  
  FREE_TXNS_ALLOWANCE("FREE_TXNS_ALLOWANCE"),
  
  INSURANCE("INSURANCE"),
  
  INTEREST_FREE("INTEREST_FREE"),
  
  INTEREST_FREE_TRANSFERS("INTEREST_FREE_TRANSFERS"),
  
  LOYALTY_PROGRAM("LOYALTY_PROGRAM"),
  
  NOTIFICATIONS("NOTIFICATIONS"),
  
  NPP_ENABLED("NPP_ENABLED"),
  
  NPP_PAYID("NPP_PAYID"),
  
  OFFSET("OFFSET"),
  
  OTHER("OTHER"),
  
  OVERDRAFT("OVERDRAFT"),
  
  REDRAW("REDRAW"),
  
  UNLIMITED_TXNS("UNLIMITED_TXNS");

  private String value;

  FeatureType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static FeatureType fromValue(String value) {
    for (FeatureType b : FeatureType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

