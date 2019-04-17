package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Object that contains links to additional information on specific topics
 */
@Embeddable
@ApiModel(description = "Object that contains links to additional information on specific topics")
public class BankingProductAdditionalInformation   {
  @JsonProperty("bundleUri")
  private String bundleUri;

  @JsonProperty("eligibilityUri")
  private String eligibilityUri;

  @JsonProperty("feesAndPricingUri")
  private String feesAndPricingUri;

  @JsonProperty("overviewUri")
  private String overviewUri;

  @JsonProperty("termsUri")
  private String termsUri;

  public BankingProductAdditionalInformation bundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
    return this;
  }

  /**
   * Description of a bundle that this product can be part of
   * @return bundleUri
  */
  @ApiModelProperty(value = "Description of a bundle that this product can be part of")


  public String getBundleUri() {
    return bundleUri;
  }

  public void setBundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
  }

  public BankingProductAdditionalInformation eligibilityUri(String eligibilityUri) {
    this.eligibilityUri = eligibilityUri;
    return this;
  }

  /**
   * Eligibility rules and criteria for the product
   * @return eligibilityUri
  */
  @ApiModelProperty(value = "Eligibility rules and criteria for the product")


  public String getEligibilityUri() {
    return eligibilityUri;
  }

  public void setEligibilityUri(String eligibilityUri) {
    this.eligibilityUri = eligibilityUri;
  }

  public BankingProductAdditionalInformation feesAndPricingUri(String feesAndPricingUri) {
    this.feesAndPricingUri = feesAndPricingUri;
    return this;
  }

  /**
   * Description of fees, pricing, discounts, exemptions and bonuses for the product
   * @return feesAndPricingUri
  */
  @ApiModelProperty(value = "Description of fees, pricing, discounts, exemptions and bonuses for the product")


  public String getFeesAndPricingUri() {
    return feesAndPricingUri;
  }

  public void setFeesAndPricingUri(String feesAndPricingUri) {
    this.feesAndPricingUri = feesAndPricingUri;
  }

  public BankingProductAdditionalInformation overviewUri(String overviewUri) {
    this.overviewUri = overviewUri;
    return this;
  }

  /**
   * General overview of the product
   * @return overviewUri
  */
  @ApiModelProperty(value = "General overview of the product")


  public String getOverviewUri() {
    return overviewUri;
  }

  public void setOverviewUri(String overviewUri) {
    this.overviewUri = overviewUri;
  }

  public BankingProductAdditionalInformation termsUri(String termsUri) {
    this.termsUri = termsUri;
    return this;
  }

  /**
   * Terms and conditions for the product
   * @return termsUri
  */
  @ApiModelProperty(value = "Terms and conditions for the product")


  public String getTermsUri() {
    return termsUri;
  }

  public void setTermsUri(String termsUri) {
    this.termsUri = termsUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductAdditionalInformation bankingProductAdditionalInformation = (BankingProductAdditionalInformation) o;
    return Objects.equals(this.bundleUri, bankingProductAdditionalInformation.bundleUri) &&
        Objects.equals(this.eligibilityUri, bankingProductAdditionalInformation.eligibilityUri) &&
        Objects.equals(this.feesAndPricingUri, bankingProductAdditionalInformation.feesAndPricingUri) &&
        Objects.equals(this.overviewUri, bankingProductAdditionalInformation.overviewUri) &&
        Objects.equals(this.termsUri, bankingProductAdditionalInformation.termsUri);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

