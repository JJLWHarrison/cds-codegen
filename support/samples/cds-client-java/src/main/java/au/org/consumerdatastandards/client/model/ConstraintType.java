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
 * The type of constraint described.  See the next section for an overview of valid values and their meaning
 */
@JsonAdapter(ConstraintType.Adapter.class)
public enum ConstraintType {
  
  MAX_BALANCE("MAX_BALANCE"),
  
  MAX_LIMIT("MAX_LIMIT"),
  
  MIN_BALANCE("MIN_BALANCE"),
  
  MIN_LIMIT("MIN_LIMIT"),
  
  OPENING_BALANCE("OPENING_BALANCE");

  private String value;

  ConstraintType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ConstraintType fromValue(String value) {
    for (ConstraintType b : ConstraintType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ConstraintType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ConstraintType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ConstraintType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ConstraintType.fromValue(value);
    }
  }
}

