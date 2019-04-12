package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.reference.models.ConstraintType;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;


public class BankingProductConstraint   {
  
  private String additionalInfo = null;
  private String additionalInfoUri = null;
  private String additionalValue = null;
  private ConstraintType constraintType = null;

  /**
   * Display text providing more information the constraint
   **/
  
  @ApiModelProperty(value = "Display text providing more information the constraint")
  @JsonProperty("additionalInfo")
  public String getAdditionalInfo() {
    return additionalInfo;
  }
  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  /**
   * Link to a web page with more information on the constraint
   **/
  
  @ApiModelProperty(value = "Link to a web page with more information on the constraint")
  @JsonProperty("additionalInfoUri")
  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }
  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  /**
   * Generic field containing additional information relevant to the constraintType specified.  Whether mandatory or not is dependent on the value of constraintType
   **/
  
  @ApiModelProperty(value = "Generic field containing additional information relevant to the constraintType specified.  Whether mandatory or not is dependent on the value of constraintType")
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
  @JsonProperty("constraintType")
  @NotNull
  public ConstraintType getConstraintType() {
    return constraintType;
  }
  public void setConstraintType(ConstraintType constraintType) {
    this.constraintType = constraintType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductConstraint bankingProductConstraint = (BankingProductConstraint) o;
    return Objects.equals(additionalInfo, bankingProductConstraint.additionalInfo) &&
        Objects.equals(additionalInfoUri, bankingProductConstraint.additionalInfoUri) &&
        Objects.equals(additionalValue, bankingProductConstraint.additionalValue) &&
        Objects.equals(constraintType, bankingProductConstraint.constraintType);
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

