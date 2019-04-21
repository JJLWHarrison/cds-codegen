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
 * The unit of measure that applies to the tierValueMinimum and tierValueMaximum values e.g. &#39;DOLLAR&#39;, &#39;MONTH&#39; (in the case of term deposit tiers), &#39;PERCENT&#39; (in the case of loan-to-value ratio or LVR)
 */
@JsonAdapter(UnitOfMeasure.Adapter.class)
public enum UnitOfMeasure {
  
  DAY("DAY"),
  
  DOLLAR("DOLLAR"),
  
  MONTH("MONTH"),
  
  PERCENT("PERCENT");

  private String value;

  UnitOfMeasure(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static UnitOfMeasure fromValue(String value) {
    for (UnitOfMeasure b : UnitOfMeasure.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<UnitOfMeasure> {
    @Override
    public void write(final JsonWriter jsonWriter, final UnitOfMeasure enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UnitOfMeasure read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UnitOfMeasure.fromValue(value);
    }
  }
}

