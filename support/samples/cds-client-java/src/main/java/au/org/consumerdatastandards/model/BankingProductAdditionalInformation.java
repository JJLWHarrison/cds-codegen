/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Object that contains links to additional information on specific topics
 */
@ApiModel(description = "Object that contains links to additional information on specific topics")
public class BankingProductAdditionalInformation {
  public static final String SERIALIZED_NAME_BUNDLE_URI = "bundleUri";
  @SerializedName(SERIALIZED_NAME_BUNDLE_URI)
  private String bundleUri;

  public static final String SERIALIZED_NAME_ELIGIBILITY_URI = "eligibilityUri";
  @SerializedName(SERIALIZED_NAME_ELIGIBILITY_URI)
  private String eligibilityUri;

  public static final String SERIALIZED_NAME_FEES_AND_PRICING_URI = "feesAndPricingUri";
  @SerializedName(SERIALIZED_NAME_FEES_AND_PRICING_URI)
  private String feesAndPricingUri;

  public static final String SERIALIZED_NAME_OVERVIEW_URI = "overviewUri";
  @SerializedName(SERIALIZED_NAME_OVERVIEW_URI)
  private String overviewUri;

  public static final String SERIALIZED_NAME_TERMS_URI = "termsUri";
  @SerializedName(SERIALIZED_NAME_TERMS_URI)
  private String termsUri;

  public BankingProductAdditionalInformation bundleUri(String bundleUri) {
    this.bundleUri = bundleUri;
    return this;
  }

   /**
   * Description of a bundle that this product can be part of
   * @return bundleUri
  **/
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
  **/
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
  **/
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
  **/
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
  **/
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

