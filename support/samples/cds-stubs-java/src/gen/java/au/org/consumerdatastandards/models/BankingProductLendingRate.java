package au.org.consumerdatastandards.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.BankingProductRateTier;
import au.org.consumerdatastandards.models.InterestPaymentDue;
import au.org.consumerdatastandards.models.LendingRateType;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import javax.validation.constraints.*;

public class BankingProductLendingRate {

    private String additionalInfo = null;
    private String additionalInfoUri = null;
    private String additionalValue = null;
    private String applicationFrequency = null;
    private String calculationFrequency = null;
    private String comparisonRate = null;
    private InterestPaymentDue interestPaymentDue = null;
    private LendingRateType lendingRateType = null;
    private String rate = null;
    private List<BankingProductRateTier> tiers = new ArrayList<BankingProductRateTier>();

    /**
     * Display text providing more information on the rate.
     **/

    @ApiModelProperty(value = "Display text providing more information on the rate.")
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
     * lendingRateType specified. Whether mandatory or not is dependent on the value
     * of lendingRateType
     **/

    @ApiModelProperty(value = "Generic field containing additional information relevant to the lendingRateType specified. Whether mandatory or not is dependent on the value of lendingRateType")
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
     * A comparison rate equivalent for this rate
     **/

    @ApiModelProperty(value = "A comparison rate equivalent for this rate")
    @JsonProperty("comparisonRate")
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getComparisonRate() {
        return comparisonRate;
    }

    public void setComparisonRate(String comparisonRate) {
        this.comparisonRate = comparisonRate;
    }

    /**
     **/

    @ApiModelProperty(value = "")
    @JsonProperty("interestPaymentDue")
    public InterestPaymentDue getInterestPaymentDue() {
        return interestPaymentDue;
    }

    public void setInterestPaymentDue(InterestPaymentDue interestPaymentDue) {
        this.interestPaymentDue = interestPaymentDue;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("lendingRateType")
    @NotNull
    public LendingRateType getLendingRateType() {
        return lendingRateType;
    }

    public void setLendingRateType(LendingRateType lendingRateType) {
        this.lendingRateType = lendingRateType;
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
        BankingProductLendingRate bankingProductLendingRate = (BankingProductLendingRate) o;
        return Objects.equals(additionalInfo, bankingProductLendingRate.additionalInfo)
                && Objects.equals(additionalInfoUri, bankingProductLendingRate.additionalInfoUri)
                && Objects.equals(additionalValue, bankingProductLendingRate.additionalValue)
                && Objects.equals(applicationFrequency, bankingProductLendingRate.applicationFrequency)
                && Objects.equals(calculationFrequency, bankingProductLendingRate.calculationFrequency)
                && Objects.equals(comparisonRate, bankingProductLendingRate.comparisonRate)
                && Objects.equals(interestPaymentDue, bankingProductLendingRate.interestPaymentDue)
                && Objects.equals(lendingRateType, bankingProductLendingRate.lendingRateType)
                && Objects.equals(rate, bankingProductLendingRate.rate)
                && Objects.equals(tiers, bankingProductLendingRate.tiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, applicationFrequency,
                calculationFrequency, comparisonRate, interestPaymentDue, lendingRateType, rate, tiers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankingProductLendingRate {\n");

        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
        sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
        sb.append("    applicationFrequency: ").append(toIndentedString(applicationFrequency)).append("\n");
        sb.append("    calculationFrequency: ").append(toIndentedString(calculationFrequency)).append("\n");
        sb.append("    comparisonRate: ").append(toIndentedString(comparisonRate)).append("\n");
        sb.append("    interestPaymentDue: ").append(toIndentedString(interestPaymentDue)).append("\n");
        sb.append("    lendingRateType: ").append(toIndentedString(lendingRateType)).append("\n");
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
