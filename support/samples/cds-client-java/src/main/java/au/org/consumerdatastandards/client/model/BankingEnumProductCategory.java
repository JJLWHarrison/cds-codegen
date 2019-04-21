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
 * The list of available product categories for categorising products and accounts.  See [here](#product-categories) for more details
 */
@JsonAdapter(BankingEnumProductCategory.Adapter.class)
public enum BankingEnumProductCategory {
  
  CRED_AND_CHRG_CARDS("CRED_AND_CHRG_CARDS"),
  
  LEASES("LEASES"),
  
  MARGIN_LOANS("MARGIN_LOANS"),
  
  PERS_LOANS("PERS_LOANS"),
  
  REGULATED_TRUST_ACCOUNTS("REGULATED_TRUST_ACCOUNTS"),
  
  RESIDENTIAL_MORTGAGES("RESIDENTIAL_MORTGAGES"),
  
  TERM_DEPOSITS("TERM_DEPOSITS"),
  
  TRADE_FINANCE("TRADE_FINANCE"),
  
  TRANS_AND_SAVINGS_ACCOUNTS("TRANS_AND_SAVINGS_ACCOUNTS"),
  
  TRAVEL_CARDS("TRAVEL_CARDS");

  private String value;

  BankingEnumProductCategory(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static BankingEnumProductCategory fromValue(String value) {
    for (BankingEnumProductCategory b : BankingEnumProductCategory.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<BankingEnumProductCategory> {
    @Override
    public void write(final JsonWriter jsonWriter, final BankingEnumProductCategory enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public BankingEnumProductCategory read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return BankingEnumProductCategory.fromValue(value);
    }
  }
}

