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
 * The type of rate (fixed, variable, etc). See the next section for an overview of valid values and their meaning
 */
@JsonAdapter(LendingRateType.Adapter.class)
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

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static LendingRateType fromValue(String value) {
    for (LendingRateType b : LendingRateType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<LendingRateType> {
    @Override
    public void write(final JsonWriter jsonWriter, final LendingRateType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public LendingRateType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return LendingRateType.fromValue(value);
    }
  }
}

