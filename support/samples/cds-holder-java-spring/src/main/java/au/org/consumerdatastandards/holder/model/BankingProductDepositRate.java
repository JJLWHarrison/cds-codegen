package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BankingProductDepositRate   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer productDepositRateId;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("applicationFrequency")
  private String applicationFrequency;

  @JsonProperty("calculationFrequency")
  private String calculationFrequency;

  @JsonProperty("depositRateType")
  private DepositRateType depositRateType;

  @JsonProperty("rate")
  private String rate;

  @OneToMany(mappedBy = "depositRate")
  @JsonProperty("tiers")
  @Valid
  private List<BankingProductRateTier> tiers = null;

  public Integer getProductDepositRateId() {
    return productDepositRateId;
  }

  public void setProductDepositRateId(Integer productDepositRateId) {
    this.productDepositRateId = productDepositRateId;
  }

  public BankingProductDepositRate additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the rate
   * @return additionalInfo
  */
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
  */
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
  */
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
   * The period after which the calculated amount(s) (see calculationFrequency) are 'applied' (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
   * @return applicationFrequency
  */
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
   * The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is 'applied' to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
   * @return calculationFrequency
  */
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
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

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
  */
  @ApiModelProperty(required = true, value = "The rate to be applied")
  @NotNull

@Pattern(regexp="^\\-?(\\d+){1,16}\\.(\\d+){1,16}") 
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
      this.tiers = new ArrayList<>();
    }
    this.tiers.add(tiersItem);
    return this;
  }

  /**
   * Rate tiers applicable for this rate
   * @return tiers
  */
  @ApiModelProperty(value = "Rate tiers applicable for this rate")

  @Valid

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

