package au.org.consumerdatastandards.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.BankingProductRateTier;
import au.org.consumerdatastandards.models.DepositRateType;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import javax.validation.constraints.*;

public class BankingProductDepositRate {

    private String additionalInfo = null;
    private String additionalInfoUri = null;
    private String additionalValue = null;
    private String applicationFrequency = null;
    private String calculationFrequency = null;
    private DepositRateType depositRateType = null;
    private String rate = null;
    private List<BankingProductRateTier> tiers = new ArrayList<BankingProductRateTier>();

    /**
     * Display text providing more information on the rate
     **/

    @ApiModelProperty(value = "Display text providing more information on the rate")
    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Link to a web page with more information on this rate
     **/

    @ApiModelProperty(value = "Link to a web page with more information on this rate")
    @JsonProperty("additionalInfoUri")
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    /**
     * Generic field containing additional information relevant to the
     * depositRateType specified. Whether mandatory or not is dependent on the value
     * of depositRateType
     **/

    @ApiModelProperty(value = "Generic field containing additional information relevant to the depositRateType specified. Whether mandatory or not is dependent on the value of depositRateType")
    @JsonProperty("additionalValue")
    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    /**
     * The period after which the calculated amount(s) (see calculationFrequency)
     * are &#39;applied&#39; (i.e. debited or credited) to the account. Formatted
     * according to [ISO 8601
     * Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
     **/

    @ApiModelProperty(value = "The period after which the calculated amount(s) (see calculationFrequency) are 'applied' (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
    @JsonProperty("applicationFrequency")
    public String getApplicationFrequency() {
        return applicationFrequency;
    }

    public void setApplicationFrequency(String applicationFrequency) {
        this.applicationFrequency = applicationFrequency;
    }

    /**
     * The period after which the rate is applied to the balance to calculate the
     * amount due for the period. Calculation of the amount is often daily (as
     * balances may change) but accumulated until the total amount is
     * &#39;applied&#39; to the account (see applicationFrequency). Formatted
     * according to [ISO 8601
     * Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
     **/

    @ApiModelProperty(value = "The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is 'applied' to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
    @JsonProperty("calculationFrequency")
    public String getCalculationFrequency() {
        return calculationFrequency;
    }

    public void setCalculationFrequency(String calculationFrequency) {
        this.calculationFrequency = calculationFrequency;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("depositRateType")
    @NotNull
    public DepositRateType getDepositRateType() {
        return depositRateType;
    }

    public void setDepositRateType(DepositRateType depositRateType) {
        this.depositRateType = depositRateType;
    }

    /**
     * The rate to be applied
     **/

    @ApiModelProperty(required = true, value = "The rate to be applied")
    @JsonProperty("rate")
    @NotNull
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    /**
     * Rate tiers applicable for this rate
     **/

    @ApiModelProperty(value = "Rate tiers applicable for this rate")
    @JsonProperty("tiers")
    public List<BankingProductRateTier> getTiers() {
        return tiers;
    }

    public void setTiers(List<BankingProductRateTier> tiers) {
        this.tiers = tiers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductDepositRate bankingProductDepositRate = (BankingProductDepositRate) o;
        return Objects.equals(additionalInfo, bankingProductDepositRate.additionalInfo)
                && Objects.equals(additionalInfoUri, bankingProductDepositRate.additionalInfoUri)
                && Objects.equals(additionalValue, bankingProductDepositRate.additionalValue)
                && Objects.equals(applicationFrequency, bankingProductDepositRate.applicationFrequency)
                && Objects.equals(calculationFrequency, bankingProductDepositRate.calculationFrequency)
                && Objects.equals(depositRateType, bankingProductDepositRate.depositRateType)
                && Objects.equals(rate, bankingProductDepositRate.rate)
                && Objects.equals(tiers, bankingProductDepositRate.tiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, applicationFrequency,
                calculationFrequency, depositRateType, rate, tiers);
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
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
