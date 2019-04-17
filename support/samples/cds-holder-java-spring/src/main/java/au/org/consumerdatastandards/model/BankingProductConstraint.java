package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class BankingProductConstraint   {
  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("constraintType")
  private ConstraintType constraintType;

  public BankingProductConstraint additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information the constraint
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information the constraint")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductConstraint additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on the constraint
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on the constraint")


  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductConstraint additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the constraintType specified.  Whether mandatory or not is dependent on the value of constraintType
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the constraintType specified.  Whether mandatory or not is dependent on the value of constraintType")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductConstraint constraintType(ConstraintType constraintType) {
    this.constraintType = constraintType;
    return this;
  }

  /**
   * Get constraintType
   * @return constraintType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ConstraintType getConstraintType() {
    return constraintType;
  }

  public void setConstraintType(ConstraintType constraintType) {
    this.constraintType = constraintType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductConstraint bankingProductConstraint = (BankingProductConstraint) o;
    return Objects.equals(this.additionalInfo, bankingProductConstraint.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductConstraint.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductConstraint.additionalValue) &&
        Objects.equals(this.constraintType, bankingProductConstraint.constraintType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, additionalInfoUri, additionalValue, constraintType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductConstraint {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    constraintType: ").append(toIndentedString(constraintType)).append("\n");
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

