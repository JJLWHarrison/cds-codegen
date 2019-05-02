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
 * The type of rate (base, bonus, etc). See the next section for an overview of valid values and their meaning
 */
@JsonAdapter(DepositRateType.Adapter.class)
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

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static DepositRateType fromValue(String value) {
    for (DepositRateType b : DepositRateType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<DepositRateType> {
    @Override
    public void write(final JsonWriter jsonWriter, final DepositRateType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public DepositRateType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return DepositRateType.fromValue(value);
    }
  }
}

