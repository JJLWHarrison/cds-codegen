package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Defines the criteria and conditions for which a rate applies
 */
@ApiModel(description = "Defines the criteria and conditions for which a rate applies")
public class BankingProductRateTier   {
  @JsonProperty("applicabilityConditions")
  private BankingProductRateCondition applicabilityConditions = null;

  @JsonProperty("maximumValue")
  private BigDecimal maximumValue;

  @JsonProperty("minimumValue")
  private BigDecimal minimumValue;

  @JsonProperty("name")
  private String name;

  @JsonProperty("rateApplicationMethod")
  private RateApplicationMethod rateApplicationMethod;

  @JsonProperty("subTier")
  private BankingProductRateTierSubTier subTier = null;

  @JsonProperty("unitOfMeasure")
  private UnitOfMeasure unitOfMeasure;

  public BankingProductRateTier applicabilityConditions(BankingProductRateCondition applicabilityConditions) {
    this.applicabilityConditions = applicabilityConditions;
    return this;
  }

  /**
   * Get applicabilityConditions
   * @return applicabilityConditions
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingProductRateCondition getApplicabilityConditions() {
    return applicabilityConditions;
  }

  public void setApplicabilityConditions(BankingProductRateCondition applicabilityConditions) {
    this.applicabilityConditions = applicabilityConditions;
  }

  public BankingProductRateTier maximumValue(BigDecimal maximumValue) {
    this.maximumValue = maximumValue;
    return this;
  }

  /**
   * The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months)
   * @return maximumValue
  */
  @ApiModelProperty(required = true, value = "The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months)")
  @NotNull

  @Valid

  public BigDecimal getMaximumValue() {
    return maximumValue;
  }

  public void setMaximumValue(BigDecimal maximumValue) {
    this.maximumValue = maximumValue;
  }

  public BankingProductRateTier minimumValue(BigDecimal minimumValue) {
    this.minimumValue = minimumValue;
    return this;
  }

  /**
   * The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value
   * @return minimumValue
  */
  @ApiModelProperty(required = true, value = "The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value")
  @NotNull

  @Valid

  public BigDecimal getMinimumValue() {
    return minimumValue;
  }

  public void setMinimumValue(BigDecimal minimumValue) {
    this.minimumValue = minimumValue;
  }

  public BankingProductRateTier name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A display name for the tier
   * @return name
  */
  @ApiModelProperty(required = true, value = "A display name for the tier")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProductRateTier rateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
    this.rateApplicationMethod = rateApplicationMethod;
    return this;
  }

  /**
   * Get rateApplicationMethod
   * @return rateApplicationMethod
  */
  @ApiModelProperty(value = "")

  @Valid

  public RateApplicationMethod getRateApplicationMethod() {
    return rateApplicationMethod;
  }

  public void setRateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
    this.rateApplicationMethod = rateApplicationMethod;
  }

  public BankingProductRateTier subTier(BankingProductRateTierSubTier subTier) {
    this.subTier = subTier;
    return this;
  }

  /**
   * Get subTier
   * @return subTier
  */
  @ApiModelProperty(value = "")

  @Valid

  public BankingProductRateTierSubTier getSubTier() {
    return subTier;
  }

  public void setSubTier(BankingProductRateTierSubTier subTier) {
    this.subTier = subTier;
  }

  public BankingProductRateTier unitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Get unitOfMeasure
   * @return unitOfMeasure
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public UnitOfMeasure getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductRateTier bankingProductRateTier = (BankingProductRateTier) o;
    return Objects.equals(this.applicabilityConditions, bankingProductRateTier.applicabilityConditions) &&
        Objects.equals(this.maximumValue, bankingProductRateTier.maximumValue) &&
        Objects.equals(this.minimumValue, bankingProductRateTier.minimumValue) &&
        Objects.equals(this.name, bankingProductRateTier.name) &&
        Objects.equals(this.rateApplicationMethod, bankingProductRateTier.rateApplicationMethod) &&
        Objects.equals(this.subTier, bankingProductRateTier.subTier) &&
        Objects.equals(this.unitOfMeasure, bankingProductRateTier.unitOfMeasure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicabilityConditions, maximumValue, minimumValue, name, rateApplicationMethod, subTier, unitOfMeasure);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

