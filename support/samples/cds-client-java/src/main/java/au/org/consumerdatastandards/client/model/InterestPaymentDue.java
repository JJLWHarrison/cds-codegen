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
 * When loan payments are due to be paid within each period. The investment benefit of earlier payments affect the rate that can be offered
 */
@JsonAdapter(InterestPaymentDue.Adapter.class)
public enum InterestPaymentDue {
  
  ADVANCE("ADVANCE"),
  
  ARREARS("ARREARS");

  private String value;

  InterestPaymentDue(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static InterestPaymentDue fromValue(String value) {
    for (InterestPaymentDue b : InterestPaymentDue.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<InterestPaymentDue> {
    @Override
    public void write(final JsonWriter jsonWriter, final InterestPaymentDue enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public InterestPaymentDue read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return InterestPaymentDue.fromValue(value);
    }
  }
}

