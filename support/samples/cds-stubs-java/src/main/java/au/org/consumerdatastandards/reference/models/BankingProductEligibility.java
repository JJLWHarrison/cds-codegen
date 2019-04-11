/*
 * Consumer Data Standards
 * Client Reference Implementation for the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 
 * NOTE: This class is auto generated by the cds-codegen package
 * https://github.com/ConsumerDataStandardsAustralia/cds-codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import au.org.consumerdatastandards.reference.models.EligibilityType;
import io.swagger.annotations.ApiModelProperty;

/**
 * BankingProductEligibility
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-11T19:35:49.725+10:00")
public class BankingProductEligibility {
    @SerializedName("additionalInfo")
    private String additionalInfo = null;

    @SerializedName("additionalInfoUri")
    private String additionalInfoUri = null;

    @SerializedName("additionalValue")
    private String additionalValue = null;

    @SerializedName("eligibilityType")
    private EligibilityType eligibilityType = null;

    public BankingProductEligibility additionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    /**
     * Display text providing more information on the eligibility criteria.
     * Mandatory if the eligibilityType field is set to OTHER
     * 
     * @return additionalInfo
     **/
    @ApiModelProperty(value = "Display text providing more information on the eligibility criteria. Mandatory if the eligibilityType field is set to OTHER")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public BankingProductEligibility additionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
        return this;
    }

    /**
     * Link to a web page with more information on this eligibility criteria
     * 
     * @return additionalInfoUri
     **/
    @ApiModelProperty(value = "Link to a web page with more information on this eligibility criteria")
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    public BankingProductEligibility additionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
        return this;
    }

    /**
     * Generic field containing additional information relevant to the
     * eligibilityType specified. Whether mandatory or not is dependent on the value
     * of eligibilityType
     * 
     * @return additionalValue
     **/
    @ApiModelProperty(value = "Generic field containing additional information relevant to the eligibilityType specified.  Whether mandatory or not is dependent on the value of eligibilityType")
    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    public BankingProductEligibility eligibilityType(EligibilityType eligibilityType) {
        this.eligibilityType = eligibilityType;
        return this;
    }

    /**
     * Get eligibilityType
     * 
     * @return eligibilityType
     **/
    @ApiModelProperty(required = true, value = "")
    public EligibilityType getEligibilityType() {
        return eligibilityType;
    }

    public void setEligibilityType(EligibilityType eligibilityType) {
        this.eligibilityType = eligibilityType;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductEligibility bankingProductEligibility = (BankingProductEligibility) o;
        return Objects.equals(this.additionalInfo, bankingProductEligibility.additionalInfo)
                && Objects.equals(this.additionalInfoUri, bankingProductEligibility.additionalInfoUri)
                && Objects.equals(this.additionalValue, bankingProductEligibility.additionalValue)
                && Objects.equals(this.eligibilityType, bankingProductEligibility.eligibilityType);
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
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
