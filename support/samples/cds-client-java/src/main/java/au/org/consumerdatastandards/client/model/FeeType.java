/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The type of fee
 */
@JsonAdapter(FeeType.Adapter.class)
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

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static FeeType fromValue(String value) {
    for (FeeType b : FeeType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<FeeType> {
    @Override
    public void write(final JsonWriter jsonWriter, final FeeType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public FeeType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return FeeType.fromValue(value);
    }
  }
}

