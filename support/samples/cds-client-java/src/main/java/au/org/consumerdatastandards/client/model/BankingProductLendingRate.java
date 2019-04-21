/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import au.org.consumerdatastandards.client.model.BankingProductRateTier;
import au.org.consumerdatastandards.client.model.InterestPaymentDue;
import au.org.consumerdatastandards.client.model.LendingRateType;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * BankingProductLendingRate
 */
public class BankingProductLendingRate {
  public static final String SERIALIZED_NAME_ADDITIONAL_INFO = "additionalInfo";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO)
  private String additionalInfo;

  public static final String SERIALIZED_NAME_ADDITIONAL_INFO_URI = "additionalInfoUri";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO_URI)
  private String additionalInfoUri;

  public static final String SERIALIZED_NAME_ADDITIONAL_VALUE = "additionalValue";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_VALUE)
  private String additionalValue;

  public static final String SERIALIZED_NAME_APPLICATION_FREQUENCY = "applicationFrequency";
  @SerializedName(SERIALIZED_NAME_APPLICATION_FREQUENCY)
  private String applicationFrequency;

  public static final String SERIALIZED_NAME_CALCULATION_FREQUENCY = "calculationFrequency";
  @SerializedName(SERIALIZED_NAME_CALCULATION_FREQUENCY)
  private String calculationFrequency;

  public static final String SERIALIZED_NAME_COMPARISON_RATE = "comparisonRate";
  @SerializedName(SERIALIZED_NAME_COMPARISON_RATE)
  private String comparisonRate;

  public static final String SERIALIZED_NAME_INTEREST_PAYMENT_DUE = "interestPaymentDue";
  @SerializedName(SERIALIZED_NAME_INTEREST_PAYMENT_DUE)
  private InterestPaymentDue interestPaymentDue;

  public static final String SERIALIZED_NAME_LENDING_RATE_TYPE = "lendingRateType";
  @SerializedName(SERIALIZED_NAME_LENDING_RATE_TYPE)
  private LendingRateType lendingRateType;

  public static final String SERIALIZED_NAME_RATE = "rate";
  @SerializedName(SERIALIZED_NAME_RATE)
  private String rate;

  public static final String SERIALIZED_NAME_TIERS = "tiers";
  @SerializedName(SERIALIZED_NAME_TIERS)
  private List<BankingProductRateTier> tiers = new ArrayList<BankingProductRateTier>();

  public BankingProductLendingRate additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * Display text providing more information on the rate.
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Display text providing more information on the rate.")
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductLendingRate additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

   /**
   * Link to a web page with more information on this rate
   * @return additionalInfoUri
  **/
  @ApiModelProperty(value = "Link to a web page with more information on this rate")
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductLendingRate additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

   /**
   * Generic field containing additional information relevant to the lendingRateType specified. Whether mandatory or not is dependent on the value of lendingRateType
   * @return additionalValue
  **/
  @ApiModelProperty(value = "Generic field containing additional information relevant to the lendingRateType specified. Whether mandatory or not is dependent on the value of lendingRateType")
  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductLendingRate applicationFrequency(String applicationFrequency) {
    this.applicationFrequency = applicationFrequency;
    return this;
  }

   /**
   * The period after which the calculated amount(s) (see calculationFrequency) are &#39;applied&#39; (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
   * @return applicationFrequency
  **/
  @ApiModelProperty(value = "The period after which the calculated amount(s) (see calculationFrequency) are 'applied' (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
  public String getApplicationFrequency() {
    return applicationFrequency;
  }

  public void setApplicationFrequency(String applicationFrequency) {
    this.applicationFrequency = applicationFrequency;
  }

  public BankingProductLendingRate calculationFrequency(String calculationFrequency) {
    this.calculationFrequency = calculationFrequency;
    return this;
  }

   /**
   * The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is &#39;applied&#39; to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
   * @return calculationFrequency
  **/
  @ApiModelProperty(value = "The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is 'applied' to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
  public String getCalculationFrequency() {
    return calculationFrequency;
  }

  public void setCalculationFrequency(String calculationFrequency) {
    this.calculationFrequency = calculationFrequency;
  }

  public BankingProductLendingRate comparisonRate(String comparisonRate) {
    this.comparisonRate = comparisonRate;
    return this;
  }

   /**
   * A comparison rate equivalent for this rate
   * @return comparisonRate
  **/
  @ApiModelProperty(value = "A comparison rate equivalent for this rate")
  public String getComparisonRate() {
    return comparisonRate;
  }

  public void setComparisonRate(String comparisonRate) {
    this.comparisonRate = comparisonRate;
  }

  public BankingProductLendingRate interestPaymentDue(InterestPaymentDue interestPaymentDue) {
    this.interestPaymentDue = interestPaymentDue;
    return this;
  }

   /**
   * Get interestPaymentDue
   * @return interestPaymentDue
  **/
  @ApiModelProperty(value = "")
  public InterestPaymentDue getInterestPaymentDue() {
    return interestPaymentDue;
  }

  public void setInterestPaymentDue(InterestPaymentDue interestPaymentDue) {
    this.interestPaymentDue = interestPaymentDue;
  }

  public BankingProductLendingRate lendingRateType(LendingRateType lendingRateType) {
    this.lendingRateType = lendingRateType;
    return this;
  }

   /**
   * Get lendingRateType
   * @return lendingRateType
  **/
  @ApiModelProperty(required = true, value = "")
  public LendingRateType getLendingRateType() {
    return lendingRateType;
  }

  public void setLendingRateType(LendingRateType lendingRateType) {
    this.lendingRateType = lendingRateType;
  }

  public BankingProductLendingRate rate(String rate) {
    this.rate = rate;
    return this;
  }

   /**
   * The rate to be applied
   * @return rate
  **/
  @ApiModelProperty(required = true, value = "The rate to be applied")
  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public BankingProductLendingRate tiers(List<BankingProductRateTier> tiers) {
    this.tiers = tiers;
    return this;
  }

  public BankingProductLendingRate addTiersItem(BankingProductRateTier tiersItem) {
    if (this.tiers == null) {
      this.tiers = new ArrayList<BankingProductRateTier>();
    }
    this.tiers.add(tiersItem);
    return this;
  }

   /**
   * Rate tiers applicable for this rate
   * @return tiers
  **/
  @ApiModelProperty(value = "Rate tiers applicable for this rate")
  public List<BankingProductRateTier> getTiers() {
    return tiers;
  }

  public void setTiers(List<BankingProductRateTier> tiers) {
    this.tiers = tiers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductLendingRate bankingProductLendingRate = (BankingProductLendingRate) o;
    return Objects.equals(this.additionalInfo, bankingProductLendingRate.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductLendingRate.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductLendingRate.additionalValue) &&
        Objects.equals(this.applicationFrequency, bankingProductLendingRate.applicationFrequency) &&
        Objects.equals(this.calculationFrequency, bankingProductLendingRate.calculationFrequency) &&
        Objects.equals(this.comparisonRate, bankingProductLendingRate.comparisonRate) &&
        Objects.equals(this.interestPaymentDue, bankingProductLendingRate.interestPaymentDue) &&
        Objects.equals(this.lendingRateType, bankingProductLendingRate.lendingRateType) &&
        Objects.equals(this.rate, bankingProductLendingRate.rate) &&
        Objects.equals(this.tiers, bankingProductLendingRate.tiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, applicationFrequency, calculationFrequency, comparisonRate, interestPaymentDue, lendingRateType, rate, tiers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductLendingRate {\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    applicationFrequency: ").append(toIndentedString(applicationFrequency)).append("\n");
    sb.append("    calculationFrequency: ").append(toIndentedString(calculationFrequency)).append("\n");
    sb.append("    comparisonRate: ").append(toIndentedString(comparisonRate)).append("\n");
    sb.append("    interestPaymentDue: ").append(toIndentedString(interestPaymentDue)).append("\n");
    sb.append("    lendingRateType: ").append(toIndentedString(lendingRateType)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
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

