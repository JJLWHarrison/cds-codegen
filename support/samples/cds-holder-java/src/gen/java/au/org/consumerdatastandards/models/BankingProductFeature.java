package au.org.consumerdatastandards.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.FeatureType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

public class BankingProductFeature {

    private String additionalInfo = null;
    private String additionalInfoUri = null;
    private String additionalValue = null;
    private FeatureType featureType = null;

    /**
     * Display text providing more information on the feature. Mandatory if the
     * feature type is set to OTHER
     **/

    @ApiModelProperty(value = "Display text providing more information on the feature. Mandatory if the feature type is set to OTHER")
    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Link to a web page with more information on this feature
     **/

    @ApiModelProperty(value = "Link to a web page with more information on this feature")
    @JsonProperty("additionalInfoUri")
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    /**
     * Generic field containing additional information relevant to the featureType
     * specified. Whether mandatory or not is dependent on the value of featureType
     **/

    @ApiModelProperty(value = "Generic field containing additional information relevant to the featureType specified. Whether mandatory or not is dependent on the value of featureType")
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
    @JsonProperty("featureType")
    @NotNull
    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductFeature bankingProductFeature = (BankingProductFeature) o;
        return Objects.equals(additionalInfo, bankingProductFeature.additionalInfo)
                && Objects.equals(additionalInfoUri, bankingProductFeature.additionalInfoUri)
                && Objects.equals(additionalValue, bankingProductFeature.additionalValue)
                && Objects.equals(featureType, bankingProductFeature.featureType);
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
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
