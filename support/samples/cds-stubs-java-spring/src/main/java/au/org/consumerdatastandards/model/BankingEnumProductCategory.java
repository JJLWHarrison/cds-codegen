package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The list of available product categories for categorising products and accounts.  See [here](#product-categories) for more details
 */
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

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BankingEnumProductCategory fromValue(String value) {
    for (BankingEnumProductCategory b : BankingEnumProductCategory.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

