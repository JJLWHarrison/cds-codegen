/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 * OpenAPI spec version: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package au.org.consumerdatastandards.model;

import java.util.Objects;
import java.util.Arrays;
import au.org.consumerdatastandards.model.BankingProductDiscountEligibility;
import au.org.consumerdatastandards.model.DiscountType;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * BankingProductDiscount
 */
public class BankingProductDiscount {
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

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_DISCOUNT_TYPE = "discountType";
  @SerializedName(SERIALIZED_NAME_DISCOUNT_TYPE)
  private DiscountType discountType;

  public static final String SERIALIZED_NAME_ELIGIBILITY = "eligibility";
  @SerializedName(SERIALIZED_NAME_ELIGIBILITY)
  private List<BankingProductDiscountEligibility> eligibility = new ArrayList<BankingProductDiscountEligibility>();

  public static final String SERIALIZED_NAME_FEE_RATE = "feeRate";
  @SerializedName(SERIALIZED_NAME_FEE_RATE)
  private String feeRate;

  public static final String SERIALIZED_NAME_TRANSACTION_RATE = "transactionRate";
  @SerializedName(SERIALIZED_NAME_TRANSACTION_RATE)
  private String transactionRate;

  public BankingProductDiscount accruedRate(String accruedRate) {
    this.accruedRate = accruedRate;
    return this;
  }

   /**
   * A discount rate calculated based on a proportion of the calculated interest accrued on the account. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee
   * @return accruedRate
  **/
  @ApiModelProperty(value = "A discount rate calculated based on a proportion of the calculated interest accrued on the account. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee")
  public String getAccruedRate() {
    return accruedRate;
  }

  public void setAccruedRate(String accruedRate) {
    this.accruedRate = accruedRate;
  }

  public BankingProductDiscount additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * Display text providing more information on the discount
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Display text providing more information on the discount")
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductDiscount additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

   /**
   * Link to a web page with more information on this discount
   * @return additionalInfoUri
  **/
  @ApiModelProperty(value = "Link to a web page with more information on this discount")
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductDiscount additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

   /**
   * Generic field containing additional information relevant to the discountType specified. Whether mandatory or not is dependent on the value of discountType
   * @return additionalValue
  **/
  @ApiModelProperty(value = "Generic field containing additional information relevant to the discountType specified. Whether mandatory or not is dependent on the value of discountType")
  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductDiscount amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Value of the discount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Value of the discount")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public BankingProductDiscount balanceRate(String balanceRate) {
    this.balanceRate = balanceRate;
    return this;
  }

   /**
   * A discount rate calculated based on a proportion of the balance. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee
   * @return balanceRate
  **/
  @ApiModelProperty(value = "A discount rate calculated based on a proportion of the balance. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee")
  public String getBalanceRate() {
    return balanceRate;
  }

  public void setBalanceRate(String balanceRate) {
    this.balanceRate = balanceRate;
  }

  public BankingProductDiscount description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the discount
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description of the discount")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankingProductDiscount discountType(DiscountType discountType) {
    this.discountType = discountType;
    return this;
  }

   /**
   * Get discountType
   * @return discountType
  **/
  @ApiModelProperty(required = true, value = "")
  public DiscountType getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountType discountType) {
    this.discountType = discountType;
  }

  public BankingProductDiscount eligibility(List<BankingProductDiscountEligibility> eligibility) {
    this.eligibility = eligibility;
    return this;
  }

  public BankingProductDiscount addEligibilityItem(BankingProductDiscountEligibility eligibilityItem) {
    if (this.eligibility == null) {
      this.eligibility = new ArrayList<BankingProductDiscountEligibility>();
    }
    this.eligibility.add(eligibilityItem);
    return this;
  }

   /**
   * Eligibility constraints that apply to this discount
   * @return eligibility
  **/
  @ApiModelProperty(value = "Eligibility constraints that apply to this discount")
  public List<BankingProductDiscountEligibility> getEligibility() {
    return eligibility;
  }

  public void setEligibility(List<BankingProductDiscountEligibility> eligibility) {
    this.eligibility = eligibility;
  }

  public BankingProductDiscount feeRate(String feeRate) {
    this.feeRate = feeRate;
    return this;
  }

   /**
   * A discount rate calculated based on a proportion of the fee to which this discount is attached. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee
   * @return feeRate
  **/
  @ApiModelProperty(value = "A discount rate calculated based on a proportion of the fee to which this discount is attached. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee")
  public String getFeeRate() {
    return feeRate;
  }

  public void setFeeRate(String feeRate) {
    this.feeRate = feeRate;
  }

  public BankingProductDiscount transactionRate(String transactionRate) {
    this.transactionRate = transactionRate;
    return this;
  }

   /**
   * A discount rate calculated based on a proportion of a transaction. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory
   * @return transactionRate
  **/
  @ApiModelProperty(value = "A discount rate calculated based on a proportion of a transaction. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory")
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
    BankingProductDiscount bankingProductDiscount = (BankingProductDiscount) o;
    return Objects.equals(this.accruedRate, bankingProductDiscount.accruedRate) &&
        Objects.equals(this.additionalInfo, bankingProductDiscount.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductDiscount.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductDiscount.additionalValue) &&
        Objects.equals(this.amount, bankingProductDiscount.amount) &&
        Objects.equals(this.balanceRate, bankingProductDiscount.balanceRate) &&
        Objects.equals(this.description, bankingProductDiscount.description) &&
        Objects.equals(this.discountType, bankingProductDiscount.discountType) &&
        Objects.equals(this.eligibility, bankingProductDiscount.eligibility) &&
        Objects.equals(this.feeRate, bankingProductDiscount.feeRate) &&
        Objects.equals(this.transactionRate, bankingProductDiscount.transactionRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accruedRate, additionalInfo, additionalInfoUri, additionalValue, amount, balanceRate, description, discountType, eligibility, feeRate, transactionRate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductDiscount {\n");
    sb.append("    accruedRate: ").append(toIndentedString(accruedRate)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    balanceRate: ").append(toIndentedString(balanceRate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    eligibility: ").append(toIndentedString(eligibility)).append("\n");
    sb.append("    feeRate: ").append(toIndentedString(feeRate)).append("\n");
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

