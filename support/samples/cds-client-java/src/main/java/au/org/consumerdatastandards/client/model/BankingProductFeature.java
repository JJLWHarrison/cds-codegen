/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import au.org.consumerdatastandards.client.model.FeatureType;
import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductFeature
 */
public class BankingProductFeature {
  public static final String SERIALIZED_NAME_ADDITIONAL_INFO = "additionalInfo";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO)
  private String additionalInfo;

  public static final String SERIALIZED_NAME_ADDITIONAL_INFO_URI = "additionalInfoUri";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFO_URI)
  private String additionalInfoUri;

  public static final String SERIALIZED_NAME_ADDITIONAL_VALUE = "additionalValue";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_VALUE)
  private String additionalValue;

  public static final String SERIALIZED_NAME_FEATURE_TYPE = "featureType";
  @SerializedName(SERIALIZED_NAME_FEATURE_TYPE)
  private FeatureType featureType;

  public BankingProductFeature additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

   /**
   * Display text providing more information on the feature. Mandatory if the feature type is set to OTHER
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Display text providing more information on the feature. Mandatory if the feature type is set to OTHER")
  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductFeature additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

   /**
   * Link to a web page with more information on this feature
   * @return additionalInfoUri
  **/
  @ApiModelProperty(value = "Link to a web page with more information on this feature")
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductFeature additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

   /**
   * Generic field containing additional information relevant to the featureType specified. Whether mandatory or not is dependent on the value of featureType
   * @return additionalValue
  **/
  @ApiModelProperty(value = "Generic field containing additional information relevant to the featureType specified. Whether mandatory or not is dependent on the value of featureType")
  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductFeature featureType(FeatureType featureType) {
    this.featureType = featureType;
    return this;
  }

   /**
   * Get featureType
   * @return featureType
  **/
  @ApiModelProperty(required = true, value = "")
  public FeatureType getFeatureType() {
    return featureType;
  }

  public void setFeatureType(FeatureType featureType) {
    this.featureType = featureType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductFeature bankingProductFeature = (BankingProductFeature) o;
    return Objects.equals(this.additionalInfo, bankingProductFeature.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductFeature.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductFeature.additionalValue) &&
        Objects.equals(this.featureType, bankingProductFeature.featureType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, featureType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductFeature {\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    featureType: ").append(toIndentedString(featureType)).append("\n");
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

