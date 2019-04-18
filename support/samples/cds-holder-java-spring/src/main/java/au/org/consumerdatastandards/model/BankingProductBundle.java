package au.org.consumerdatastandards.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BankingProductBundle   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer productBundleId;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  @JsonProperty("description")
  private String description;

  @JsonProperty("name")
  private String name;

  @Transient
  @JsonProperty("productIds")
  @Valid
  private List<String> productIds = new ArrayList<>();

  public BankingProductBundle additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the bundle
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on the bundle")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductBundle additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on the bundle criteria and benefits
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on the bundle criteria and benefits")


  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductBundle description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the bundle
   * @return description
  */
  @ApiModelProperty(required = true, value = "Description of the bundle")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankingProductBundle name(String name) {
    this.name = name;
    return this;
  }

  public Integer getProductBundleId() {
    return productBundleId;
  }

  public void setProductBundleId(Integer productBundleId) {
    this.productBundleId = productBundleId;
  }

  /**
   * Name of the bundle
   * @return name
  */
  @ApiModelProperty(required = true, value = "Name of the bundle")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProductBundle productIds(List<String> productIds) {
    this.productIds = productIds;
    return this;
  }

  public BankingProductBundle addProductIdsItem(String productIdsItem) {
    this.productIds.add(productIdsItem);
    return this;
  }

  /**
   * Array of product IDs for products included in the bundle
   * @return productIds
  */
  @ApiModelProperty(required = true, value = "Array of product IDs for products included in the bundle")
  @NotNull


  public List<String> getProductIds() {
    return productIds;
  }

  public void setProductIds(List<String> productIds) {
    this.productIds = productIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductBundle bankingProductBundle = (BankingProductBundle) o;
    return Objects.equals(this.additionalInfo, bankingProductBundle.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductBundle.additionalInfoUri) &&
        Objects.equals(this.description, bankingProductBundle.description) &&
        Objects.equals(this.name, bankingProductBundle.name) &&
        Objects.equals(this.productIds, bankingProductBundle.productIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, additionalInfoUri, description, name, productIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductBundle {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productIds: ").append(toIndentedString(productIds)).append("\n");
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

