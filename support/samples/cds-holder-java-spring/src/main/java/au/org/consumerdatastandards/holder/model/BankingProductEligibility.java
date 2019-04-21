package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class BankingProductEligibility   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer productEligibilityId;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("eligibilityType")
  private EligibilityType eligibilityType;

  public Integer getProductEligibilityId() {
    return productEligibilityId;
  }

  public void setProductEligibilityId(Integer productEligibilityId) {
    this.productEligibilityId = productEligibilityId;
  }

  public BankingProductEligibility additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the eligibility criteria. Mandatory if the eligibilityType field is set to OTHER
   * @return additionalInfo
  */
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
   * @return additionalInfoUri
  */
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
   * Generic field containing additional information relevant to the eligibilityType specified.  Whether mandatory or not is dependent on the value of eligibilityType
   * @return additionalValue
  */
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
   * @return eligibilityType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

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
    return Objects.equals(this.additionalInfo, bankingProductEligibility.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductEligibility.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductEligibility.additionalValue) &&
        Objects.equals(this.eligibilityType, bankingProductEligibility.eligibilityType);
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

