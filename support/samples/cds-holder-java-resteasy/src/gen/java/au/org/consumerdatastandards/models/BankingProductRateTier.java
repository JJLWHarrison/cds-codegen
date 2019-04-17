package au.org.consumerdatastandards.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.BankingProductRateCondition;
import au.org.consumerdatastandards.models.BankingProductRateTierSubTier;
import au.org.consumerdatastandards.models.RateApplicationMethod;
import au.org.consumerdatastandards.models.UnitOfMeasure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.validation.constraints.*;

@ApiModel(description = "Defines the criteria and conditions for which a rate applies")
public class BankingProductRateTier {

    private BankingProductRateCondition applicabilityConditions = null;
    private BigDecimal maximumValue = null;
    private BigDecimal minimumValue = null;
    private String name = null;
    private RateApplicationMethod rateApplicationMethod = null;
    private BankingProductRateTierSubTier subTier = null;
    private UnitOfMeasure unitOfMeasure = null;

    /**
     **/

    @ApiModelProperty(value = "")
    @JsonProperty("applicabilityConditions")
    public BankingProductRateCondition getApplicabilityConditions() {
        return applicabilityConditions;
    }

    public void setApplicabilityConditions(BankingProductRateCondition applicabilityConditions) {
        this.applicabilityConditions = applicabilityConditions;
    }

    /**
     * The number of tierUnitOfMeasure units that form the upper bound of the tier
     * or band. For a tier with a discrete value (as opposed to a range of values
     * e.g. 1 month) this must be the same as tierValueMinimum. Where this is the
     * same as the tierValueMinimum value of the next-higher tier the referenced
     * tier should be exclusive of this value. For example a term deposit of 2
     * months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3
     * months)
     **/

    @ApiModelProperty(required = true, value = "The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months)")
    @JsonProperty("maximumValue")
    @NotNull
    public BigDecimal getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(BigDecimal maximumValue) {
        this.maximumValue = maximumValue;
    }

    /**
     * The number of tierUnitOfMeasure units that form the lower bound of the tier.
     * The tier should be inclusive of this value
     **/

    @ApiModelProperty(required = true, value = "The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value")
    @JsonProperty("minimumValue")
    @NotNull
    public BigDecimal getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(BigDecimal minimumValue) {
        this.minimumValue = minimumValue;
    }

    /**
     * A display name for the tier
     **/

    @ApiModelProperty(required = true, value = "A display name for the tier")
    @JsonProperty("name")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     **/

    @ApiModelProperty(value = "")
    @JsonProperty("rateApplicationMethod")
    public RateApplicationMethod getRateApplicationMethod() {
        return rateApplicationMethod;
    }

    public void setRateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
        this.rateApplicationMethod = rateApplicationMethod;
    }

    /**
     **/

    @ApiModelProperty(value = "")
    @JsonProperty("subTier")
    public BankingProductRateTierSubTier getSubTier() {
        return subTier;
    }

    public void setSubTier(BankingProductRateTierSubTier subTier) {
        this.subTier = subTier;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("unitOfMeasure")
    @NotNull
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductRateTier bankingProductRateTier = (BankingProductRateTier) o;
        return Objects.equals(applicabilityConditions, bankingProductRateTier.applicabilityConditions)
                && Objects.equals(maximumValue, bankingProductRateTier.maximumValue)
                && Objects.equals(minimumValue, bankingProductRateTier.minimumValue)
                && Objects.equals(name, bankingProductRateTier.name)
                && Objects.equals(rateApplicationMethod, bankingProductRateTier.rateApplicationMethod)
                && Objects.equals(subTier, bankingProductRateTier.subTier)
                && Objects.equals(unitOfMeasure, bankingProductRateTier.unitOfMeasure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicabilityConditions, maximumValue, minimumValue, name, rateApplicationMethod, subTier,
                unitOfMeasure);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankingProductRateTier {\n");

        sb.append("    applicabilityConditions: ").append(toIndentedString(applicabilityConditions)).append("\n");
        sb.append("    maximumValue: ").append(toIndentedString(maximumValue)).append("\n");
        sb.append("    minimumValue: ").append(toIndentedString(minimumValue)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    rateApplicationMethod: ").append(toIndentedString(rateApplicationMethod)).append("\n");
        sb.append("    subTier: ").append(toIndentedString(subTier)).append("\n");
        sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
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
