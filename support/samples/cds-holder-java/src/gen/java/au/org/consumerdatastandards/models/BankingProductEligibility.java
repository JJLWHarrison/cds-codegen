package au.org.consumerdatastandards.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.EligibilityType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

public class BankingProductEligibility {

    private String additionalInfo = null;
    private String additionalInfoUri = null;
    private String additionalValue = null;
    private EligibilityType eligibilityType = null;

    /**
     * Display text providing more information on the eligibility criteria.
     * Mandatory if the eligibilityType field is set to OTHER
     **/

    @ApiModelProperty(value = "Display text providing more information on the eligibility criteria. Mandatory if the eligibilityType field is set to OTHER")
    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Link to a web page with more information on this eligibility criteria
     **/

    @ApiModelProperty(value = "Link to a web page with more information on this eligibility criteria")
    @JsonProperty("additionalInfoUri")
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    /**
     * Generic field containing additional information relevant to the
     * eligibilityType specified. Whether mandatory or not is dependent on the value
     * of eligibilityType
     **/

    @ApiModelProperty(value = "Generic field containing additional information relevant to the eligibilityType specified.  Whether mandatory or not is dependent on the value of eligibilityType")
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
    @JsonProperty("eligibilityType")
    @NotNull
    public EligibilityType getEligibilityType() {
        return eligibilityType;
    }

    public void setEligibilityType(EligibilityType eligibilityType) {
        this.eligibilityType = eligibilityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductEligibility bankingProductEligibility = (BankingProductEligibility) o;
        return Objects.equals(additionalInfo, bankingProductEligibility.additionalInfo)
                && Objects.equals(additionalInfoUri, bankingProductEligibility.additionalInfoUri)
                && Objects.equals(additionalValue, bankingProductEligibility.additionalValue)
                && Objects.equals(eligibilityType, bankingProductEligibility.eligibilityType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, eligibilityType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankingProductEligibility {\n");

        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
        sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
        sb.append("    eligibilityType: ").append(toIndentedString(eligibilityType)).append("\n");
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
