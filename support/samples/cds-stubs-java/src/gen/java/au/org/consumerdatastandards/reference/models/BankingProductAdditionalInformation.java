package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Object that contains links to additional information on specific topics")
public class BankingProductAdditionalInformation   {
  
  private String bundleUri = null;
  private String eligibilityUri = null;
  private String feesAndPricingUri = null;
  private String overviewUri = null;
  private String termsUri = null;

  /**
   * Description of a bundle that this product can be part of
   **/
  
  @ApiModelProperty(value = "Description of a bundle that this product can be part of")
  @JsonProperty("bundleUri")
  public String getBundleUri() {
    return bundleUri;
  }
  public void setBundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
  }

  /**
   * Eligibility rules and criteria for the product
   **/
  
  @ApiModelProperty(value = "Eligibility rules and criteria for the product")
  @JsonProperty("eligibilityUri")
  public String getEligibilityUri() {
    return eligibilityUri;
  }
  public void setEligibilityUri(String eligibilityUri) {
    this.eligibilityUri = eligibilityUri;
  }

  /**
   * Description of fees, pricing, discounts, exemptions and bonuses for the product
   **/
  
  @ApiModelProperty(value = "Description of fees, pricing, discounts, exemptions and bonuses for the product")
  @JsonProperty("feesAndPricingUri")
  public String getFeesAndPricingUri() {
    return feesAndPricingUri;
  }
  public void setFeesAndPricingUri(String feesAndPricingUri) {
    this.feesAndPricingUri = feesAndPricingUri;
  }

  /**
   * General overview of the product
   **/
  
  @ApiModelProperty(value = "General overview of the product")
  @JsonProperty("overviewUri")
  public String getOverviewUri() {
    return overviewUri;
  }
  public void setOverviewUri(String overviewUri) {
    this.overviewUri = overviewUri;
  }

  /**
   * Terms and conditions for the product
   **/
  
  @ApiModelProperty(value = "Terms and conditions for the product")
  @JsonProperty("termsUri")
  public String getTermsUri() {
    return termsUri;
  }
  public void setTermsUri(String termsUri) {
    this.termsUri = termsUri;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductAdditionalInformation bankingProductAdditionalInformation = (BankingProductAdditionalInformation) o;
    return Objects.equals(bundleUri, bankingProductAdditionalInformation.bundleUri) &&
        Objects.equals(eligibilityUri, bankingProductAdditionalInformation.eligibilityUri) &&
        Objects.equals(feesAndPricingUri, bankingProductAdditionalInformation.feesAndPricingUri) &&
        Objects.equals(overviewUri, bankingProductAdditionalInformation.overviewUri) &&
        Objects.equals(termsUri, bankingProductAdditionalInformation.termsUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bundleUri, eligibilityUri, feesAndPricingUri, overviewUri, termsUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductAdditionalInformation {\n");
    
    sb.append("    bundleUri: ").append(toIndentedString(bundleUri)).append("\n");
    sb.append("    eligibilityUri: ").append(toIndentedString(eligibilityUri)).append("\n");
    sb.append("    feesAndPricingUri: ").append(toIndentedString(feesAndPricingUri)).append("\n");
    sb.append("    overviewUri: ").append(toIndentedString(overviewUri)).append("\n");
    sb.append("    termsUri: ").append(toIndentedString(termsUri)).append("\n");
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

