package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.reference.models.DiscountEligibilityType;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;


public class BankingProductDiscountEligibility   {
  
  private String additionalInfo = null;
  private String additionalInfoUri = null;
  private String additionalValue = null;
  private DiscountEligibilityType discountEligibilityType = null;

  /**
   * Display text providing more information on this eligibility constraint
   **/
  
  @ApiModelProperty(value = "Display text providing more information on this eligibility constraint")
  @JsonProperty("additionalInfo")
  public String getAdditionalInfo() {
    return additionalInfo;
  }
  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  /**
   * Link to a web page with more information on this eligibility constraint
   **/
  
  @ApiModelProperty(value = "Link to a web page with more information on this eligibility constraint")
  @JsonProperty("additionalInfoUri")
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }
  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  /**
   * Generic field containing additional information relevant to the discountEligibilityType specified. Whether mandatory or not is dependent on the value of discountEligibilityType
   **/
  
  @ApiModelProperty(value = "Generic field containing additional information relevant to the discountEligibilityType specified. Whether mandatory or not is dependent on the value of discountEligibilityType")
  @JsonProperty("additionalValue")
  public String getAdditionalValue() {
    return additionalValue;
  }
  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  /**
   **/
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("discountEligibilityType")
  @NotNull
  public DiscountEligibilityType getDiscountEligibilityType() {
    return discountEligibilityType;
  }
  public void setDiscountEligibilityType(DiscountEligibilityType discountEligibilityType) {
    this.discountEligibilityType = discountEligibilityType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductDiscountEligibility bankingProductDiscountEligibility = (BankingProductDiscountEligibility) o;
    return Objects.equals(additionalInfo, bankingProductDiscountEligibility.additionalInfo) &&
        Objects.equals(additionalInfoUri, bankingProductDiscountEligibility.additionalInfoUri) &&
        Objects.equals(additionalValue, bankingProductDiscountEligibility.additionalValue) &&
        Objects.equals(discountEligibilityType, bankingProductDiscountEligibility.discountEligibilityType);
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

