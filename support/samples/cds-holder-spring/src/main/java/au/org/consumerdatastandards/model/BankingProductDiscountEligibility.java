package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * BankingProductDiscountEligibility
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-04-16T16:57:32.382+10:00[Australia/Sydney]")

public class BankingProductDiscountEligibility   {
  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("discountEligibilityType")
  private DiscountEligibilityType discountEligibilityType;

  public BankingProductDiscountEligibility additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on this eligibility constraint
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on this eligibility constraint")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductDiscountEligibility additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on this eligibility constraint
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on this eligibility constraint")


  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductDiscountEligibility additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the discountEligibilityType specified. Whether mandatory or not is dependent on the value of discountEligibilityType
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the discountEligibilityType specified. Whether mandatory or not is dependent on the value of discountEligibilityType")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductDiscountEligibility discountEligibilityType(DiscountEligibilityType discountEligibilityType) {
    this.discountEligibilityType = discountEligibilityType;
    return this;
  }

  /**
   * Get discountEligibilityType
   * @return discountEligibilityType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public DiscountEligibilityType getDiscountEligibilityType() {
    return discountEligibilityType;
  }

  public void setDiscountEligibilityType(DiscountEligibilityType discountEligibilityType) {
    this.discountEligibilityType = discountEligibilityType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductDiscountEligibility bankingProductDiscountEligibility = (BankingProductDiscountEligibility) o;
    return Objects.equals(this.additionalInfo, bankingProductDiscountEligibility.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductDiscountEligibility.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductDiscountEligibility.additionalValue) &&
        Objects.equals(this.discountEligibilityType, bankingProductDiscountEligibility.discountEligibilityType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, discountEligibilityType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductDiscountEligibility {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    discountEligibilityType: ").append(toIndentedString(discountEligibilityType)).append("\n");
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

