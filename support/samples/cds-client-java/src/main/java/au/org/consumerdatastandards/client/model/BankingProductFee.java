/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import au.org.consumerdatastandards.client.model.BankingProductDiscount;
import au.org.consumerdatastandards.client.model.FeeType;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * BankingProductFee
 */
public class BankingProductFee {
  public static final String SERIALIZED_NAME_ACCRUAL_FREQUENCY = "accrualFrequency";
  @SerializedName(SERIALIZED_NAME_ACCRUAL_FREQUENCY)
  private String accrualFrequency;

  public static final String SERIALIZED_NAME_ACCRUED_RATE = "accruedRate";
  @SerializedName(SERIALIZED_NAME_ACCRUED_RATE)
  private String accruedRate;

  public static final String SERIALIZED_NAME_ADDITIONAL_INFO = "additionalInfo";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO)
  private String additionalInfo;

  public static final String SERIALIZED_NAME_ADDITIONAL_INFO_URI = "additionalInfoUri";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO_URI)
  private String additionalInfoUri;

  public static final String SERIALIZED_NAME_ADDITIONAL_VALUE = "additionalValue";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_VALUE)
  private String additionalValue;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private String amount;

  public static final String SERIALIZED_NAME_BALANCE_RATE = "balanceRate";
  @SerializedName(SERIALIZED_NAME_BALANCE_RATE)
  private String balanceRate;

  public static final String SERIALIZED_NAME_CURRENCY = "currency";
  @SerializedName(SERIALIZED_NAME_CURRENCY)
  private String currency;

  public static final String SERIALIZED_NAME_DISCOUNTS = "discounts";
  @SerializedName(SERIALIZED_NAME_DISCOUNTS)
  private List<BankingProductDiscount> discounts = new ArrayList<BankingProductDiscount>();

  public static final String SERIALIZED_NAME_FEE_TYPE = "feeType";
  @SerializedName(SERIALIZED_NAME_FEE_TYPE)
  private FeeType feeType;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_TRANSACTION_RATE = "transactionRate";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_RATE)
  private String transactionRate;

  public BankingProductFee accrualFrequency(String accrualFrequency) {
    this.accrualFrequency = accrualFrequency;
    return this;
  }

   /**
   * The indicative frequency with which the fee is calculated on the account. Only applies if balanceRate or accruedRate is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
   * @return accrualFrequency
  **/
  @ApiModelProperty(value = "The indicative frequency with which the fee is calculated on the account. Only applies if balanceRate or accruedRate is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
  public String getAccrualFrequency() {
    return accrualFrequency;
  }

  public void setAccrualFrequency(String accrualFrequency) {
    this.accrualFrequency = accrualFrequency;
  }

  public BankingProductFee accruedRate(String accruedRate) {
    this.accruedRate = accruedRate;
    return this;
  }

   /**
   * A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return accruedRate
  **/
  @ApiModelProperty(value = "A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
  public String getAccruedRate() {
    return accruedRate;
  }

  public void setAccruedRate(String accruedRate) {
    this.accruedRate = accruedRate;
  }

  public BankingProductFee additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * Display text providing more information on the fee
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Display text providing more information on the fee")
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductFee additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

   /**
   * Link to a web page with more information on this fee
   * @return additionalInfoUri
  **/
  @ApiModelProperty(value = "Link to a web page with more information on this fee")
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductFee additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

   /**
   * Generic field containing additional information relevant to the feeType specified. Whether mandatory or not is dependent on the value of feeType
   * @return additionalValue
  **/
  @ApiModelProperty(value = "Generic field containing additional information relevant to the feeType specified. Whether mandatory or not is dependent on the value of feeType")
  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductFee amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public BankingProductFee balanceRate(String balanceRate) {
    this.balanceRate = balanceRate;
    return this;
  }

   /**
   * A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return balanceRate
  **/
  @ApiModelProperty(value = "A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
  public String getBalanceRate() {
    return balanceRate;
  }

  public void setBalanceRate(String balanceRate) {
    this.balanceRate = balanceRate;
  }

  public BankingProductFee currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * The currency the fee will be charged in. Assumes AUD if absent
   * @return currency
  **/
  @ApiModelProperty(value = "The currency the fee will be charged in. Assumes AUD if absent")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BankingProductFee discounts(List<BankingProductDiscount> discounts) {
    this.discounts = discounts;
    return this;
  }

  public BankingProductFee addDiscountsItem(BankingProductDiscount discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<BankingProductDiscount>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

   /**
   * An optional list of discounts to this fee that may be available
   * @return discounts
  **/
  @ApiModelProperty(value = "An optional list of discounts to this fee that may be available")
  public List<BankingProductDiscount> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<BankingProductDiscount> discounts) {
    this.discounts = discounts;
  }

  public BankingProductFee feeType(FeeType feeType) {
    this.feeType = feeType;
    return this;
  }

   /**
   * Get feeType
   * @return feeType
  **/
  @ApiModelProperty(required = true, value = "")
  public FeeType getFeeType() {
    return feeType;
  }

  public void setFeeType(FeeType feeType) {
    this.feeType = feeType;
  }

  public BankingProductFee name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the fee
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the fee")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProductFee transactionRate(String transactionRate) {
    this.transactionRate = transactionRate;
    return this;
  }

   /**
   * A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return transactionRate
  **/
  @ApiModelProperty(value = "A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
  public String getTransactionRate() {
    return transactionRate;
  }

  public void setTransactionRate(String transactionRate) {
    this.transactionRate = transactionRate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductFee bankingProductFee = (BankingProductFee) o;
    return Objects.equals(this.accrualFrequency, bankingProductFee.accrualFrequency) &&
        Objects.equals(this.accruedRate, bankingProductFee.accruedRate) &&
        Objects.equals(this.additionalInfo, bankingProductFee.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductFee.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductFee.additionalValue) &&
        Objects.equals(this.amount, bankingProductFee.amount) &&
        Objects.equals(this.balanceRate, bankingProductFee.balanceRate) &&
        Objects.equals(this.currency, bankingProductFee.currency) &&
        Objects.equals(this.discounts, bankingProductFee.discounts) &&
        Objects.equals(this.feeType, bankingProductFee.feeType) &&
        Objects.equals(this.name, bankingProductFee.name) &&
        Objects.equals(this.transactionRate, bankingProductFee.transactionRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accrualFrequency, accruedRate, additionalInfo, additionalInfoUri, additionalValue, amount, balanceRate, currency, discounts, feeType, name, transactionRate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductFee {\n");
    sb.append("    accrualFrequency: ").append(toIndentedString(accrualFrequency)).append("\n");
    sb.append("    accruedRate: ").append(toIndentedString(accruedRate)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    balanceRate: ").append(toIndentedString(balanceRate)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    feeType: ").append(toIndentedString(feeType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    transactionRate: ").append(toIndentedString(transactionRate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

