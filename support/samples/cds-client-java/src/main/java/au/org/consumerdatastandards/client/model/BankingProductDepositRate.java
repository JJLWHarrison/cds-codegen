/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.model;

import java.util.Objects;
import java.util.Arrays;
import au.org.consumerdatastandards.model.BankingProductRateTier;
import au.org.consumerdatastandards.model.DepositRateType;
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
 * BankingProductDepositRate
 */
public class BankingProductDepositRate {
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

  public static final String SERIALIZED_NAME_DEPOSIT_RATE_TYPE = "depositRateType";
  @SerializedName(SERIALIZED_NAME_DEPOSIT_RATE_TYPE)
  private DepositRateType depositRateType;

  public static final String SERIALIZED_NAME_RATE = "rate";
  @SerializedName(SERIALIZED_NAME_RATE)
  private String rate;

  public static final String SERIALIZED_NAME_TIERS = "tiers";
  @SerializedName(SERIALIZED_NAME_TIERS)
  private List<BankingProductRateTier> tiers = new ArrayList<BankingProductRateTier>();

  public BankingProductDepositRate additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * Display text providing more information on the rate
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Display text providing more information on the rate")
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductDepositRate additionalInfoUri(String additionalInfoUri) {
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

  public BankingProductDepositRate additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

   /**
   * Generic field containing additional information relevant to the depositRateType specified. Whether mandatory or not is dependent on the value of depositRateType
   * @return additionalValue
  **/
  @ApiModelProperty(value = "Generic field containing additional information relevant to the depositRateType specified. Whether mandatory or not is dependent on the value of depositRateType")
  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductDepositRate applicationFrequency(String applicationFrequency) {
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

  public BankingProductDepositRate calculationFrequency(String calculationFrequency) {
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

  public BankingProductDepositRate depositRateType(DepositRateType depositRateType) {
    this.depositRateType = depositRateType;
    return this;
  }

   /**
   * Get depositRateType
   * @return depositRateType
  **/
  @ApiModelProperty(required = true, value = "")
  public DepositRateType getDepositRateType() {
    return depositRateType;
  }

  public void setDepositRateType(DepositRateType depositRateType) {
    this.depositRateType = depositRateType;
  }

  public BankingProductDepositRate rate(String rate) {
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

  public BankingProductDepositRate tiers(List<BankingProductRateTier> tiers) {
    this.tiers = tiers;
    return this;
  }

  public BankingProductDepositRate addTiersItem(BankingProductRateTier tiersItem) {
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
    BankingProductDepositRate bankingProductDepositRate = (BankingProductDepositRate) o;
    return Objects.equals(this.additionalInfo, bankingProductDepositRate.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductDepositRate.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductDepositRate.additionalValue) &&
        Objects.equals(this.applicationFrequency, bankingProductDepositRate.applicationFrequency) &&
        Objects.equals(this.calculationFrequency, bankingProductDepositRate.calculationFrequency) &&
        Objects.equals(this.depositRateType, bankingProductDepositRate.depositRateType) &&
        Objects.equals(this.rate, bankingProductDepositRate.rate) &&
        Objects.equals(this.tiers, bankingProductDepositRate.tiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, applicationFrequency, calculationFrequency, depositRateType, rate, tiers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductDepositRate {\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    applicationFrequency: ").append(toIndentedString(applicationFrequency)).append("\n");
    sb.append("    calculationFrequency: ").append(toIndentedString(calculationFrequency)).append("\n");
    sb.append("    depositRateType: ").append(toIndentedString(depositRateType)).append("\n");
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

