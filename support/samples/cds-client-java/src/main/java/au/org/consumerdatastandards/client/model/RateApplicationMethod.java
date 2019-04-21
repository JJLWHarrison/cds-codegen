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
 * The method used to calculate the amount to be applied using one or more tiers. A single rate may be applied to the entire balance or each applicable tier rate is applied to the portion of the balance that falls into that tier (referred to as &#39;bands&#39; or &#39;steps&#39;)
 */
@JsonAdapter(RateApplicationMethod.Adapter.class)
public enum RateApplicationMethod {
  
  PER_TIER("PER_TIER"),
  
  WHOLE_BALANCE("WHOLE_BALANCE");

  private String value;

  RateApplicationMethod(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static RateApplicationMethod fromValue(String value) {
    for (RateApplicationMethod b : RateApplicationMethod.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<RateApplicationMethod> {
    @Override
    public void write(final JsonWriter jsonWriter, final RateApplicationMethod enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public RateApplicationMethod read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return RateApplicationMethod.fromValue(value);
    }
  }
}

