/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.model;

import java.util.Objects;
import java.util.Arrays;
import au.org.consumerdatastandards.model.BankingProductRateCondition;
import au.org.consumerdatastandards.model.RateApplicationMethod;
import au.org.consumerdatastandards.model.UnitOfMeasure;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Defines the sub-tier criteria and conditions for which a rate applies
 */
@ApiModel(description = "Defines the sub-tier criteria and conditions for which a rate applies")
public class BankingProductRateTierSubTier {
  public static final String SERIALIZED_NAME_APPLICABILITY_CONDITIONS = "applicabilityConditions";
  @SerializedName(SERIALIZED_NAME_APPLICABILITY_CONDITIONS)
  private BankingProductRateCondition applicabilityConditions = null;

  public static final String SERIALIZED_NAME_MAXIMUM_VALUE = "maximumValue";
  @SerializedName(SERIALIZED_NAME_MAXIMUM_VALUE)
  private BigDecimal maximumValue;

  public static final String SERIALIZED_NAME_MINIMUM_VALUE = "minimumValue";
  @SerializedName(SERIALIZED_NAME_MINIMUM_VALUE)
  private BigDecimal minimumValue;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_RATE_APPLICATION_METHOD = "rateApplicationMethod";
  @SerializedName(SERIALIZED_NAME_RATE_APPLICATION_METHOD)
  private RateApplicationMethod rateApplicationMethod;

  public static final String SERIALIZED_NAME_UNIT_OF_MEASURE = "unitOfMeasure";
  @SerializedName(SERIALIZED_NAME_UNIT_OF_MEASURE)
  private UnitOfMeasure unitOfMeasure;

  public BankingProductRateTierSubTier applicabilityConditions(BankingProductRateCondition applicabilityConditions) {
    this.applicabilityConditions = applicabilityConditions;
    return this;
  }

   /**
   * Get applicabilityConditions
   * @return applicabilityConditions
  **/
  @ApiModelProperty(value = "")
  public BankingProductRateCondition getApplicabilityConditions() {
    return applicabilityConditions;
  }

  public void setApplicabilityConditions(BankingProductRateCondition applicabilityConditions) {
    this.applicabilityConditions = applicabilityConditions;
  }

  public BankingProductRateTierSubTier maximumValue(BigDecimal maximumValue) {
    this.maximumValue = maximumValue;
    return this;
  }

   /**
   * The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months)
   * @return maximumValue
  **/
  @ApiModelProperty(required = true, value = "The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months)")
  public BigDecimal getMaximumValue() {
    return maximumValue;
  }

  public void setMaximumValue(BigDecimal maximumValue) {
    this.maximumValue = maximumValue;
  }

  public BankingProductRateTierSubTier minimumValue(BigDecimal minimumValue) {
    this.minimumValue = minimumValue;
    return this;
  }

   /**
   * The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value
   * @return minimumValue
  **/
  @ApiModelProperty(required = true, value = "The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value")
  public BigDecimal getMinimumValue() {
    return minimumValue;
  }

  public void setMinimumValue(BigDecimal minimumValue) {
    this.minimumValue = minimumValue;
  }

  public BankingProductRateTierSubTier name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A display name for the tier
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A display name for the tier")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProductRateTierSubTier rateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
    this.rateApplicationMethod = rateApplicationMethod;
    return this;
  }

   /**
   * Get rateApplicationMethod
   * @return rateApplicationMethod
  **/
  @ApiModelProperty(value = "")
  public RateApplicationMethod getRateApplicationMethod() {
    return rateApplicationMethod;
  }

  public void setRateApplicationMethod(RateApplicationMethod rateApplicationMethod) {
    this.rateApplicationMethod = rateApplicationMethod;
  }

  public BankingProductRateTierSubTier unitOfMeasure(UnitOfMeasure unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

   /**
   * Get unitOfMeasure
   * @return unitOfMeasure
  **/
  @ApiModelProperty(required = true, value = "")
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
    BankingProductRateTierSubTier bankingProductRateTierSubTier = (BankingProductRateTierSubTier) o;
    return Objects.equals(this.applicabilityConditions, bankingProductRateTierSubTier.applicabilityConditions) &&
        Objects.equals(this.maximumValue, bankingProductRateTierSubTier.maximumValue) &&
        Objects.equals(this.minimumValue, bankingProductRateTierSubTier.minimumValue) &&
        Objects.equals(this.name, bankingProductRateTierSubTier.name) &&
        Objects.equals(this.rateApplicationMethod, bankingProductRateTierSubTier.rateApplicationMethod) &&
        Objects.equals(this.unitOfMeasure, bankingProductRateTierSubTier.unitOfMeasure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicabilityConditions, maximumValue, minimumValue, name, rateApplicationMethod, unitOfMeasure);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductRateTierSubTier {\n");
    sb.append("    applicabilityConditions: ").append(toIndentedString(applicabilityConditions)).append("\n");
    sb.append("    maximumValue: ").append(toIndentedString(maximumValue)).append("\n");
    sb.append("    minimumValue: ").append(toIndentedString(minimumValue)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    rateApplicationMethod: ").append(toIndentedString(rateApplicationMethod)).append("\n");
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

