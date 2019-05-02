/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The type of feature described
 */
@JsonAdapter(FeatureType.Adapter.class)
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

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static FeatureType fromValue(String value) {
    for (FeatureType b : FeatureType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<FeatureType> {
    @Override
    public void write(final JsonWriter jsonWriter, final FeatureType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public FeatureType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return FeatureType.fromValue(value);
    }
  }
}

