package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.reference.models.BankingEnumProductCategory;
import au.org.consumerdatastandards.reference.models.BankingProductAdditionalInformation;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.validation.constraints.*;

public class BankingProduct   {
  
  private BankingProductAdditionalInformation additionalInformation = null;
  private String applicationUri = null;
  private String brand = null;
  private String brandName = null;
  private String description = null;
  private Date effectiveFrom = null;
  private Date effectiveTo = null;
  private Boolean isTailored = null;
  private Date lastUpdated = null;
  private String name = null;
  private BankingEnumProductCategory productCategory = null;
  private String productId = null;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("additionalInformation")
  public BankingProductAdditionalInformation getAdditionalInformation() {
    return additionalInformation;
  }
  public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  /**
   * A link to the an application web page where this product can be applied for.
   **/
  
  @ApiModelProperty(value = "A link to the an application web page where this product can be applied for.")
  @JsonProperty("applicationUri")
  public String getApplicationUri() {
    return applicationUri;
  }
  public void setApplicationUri(String applicationUri) {
    this.applicationUri = applicationUri;
  }

  /**
   * A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required
   **/
  
  @ApiModelProperty(required = true, value = "A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required")
  @JsonProperty("brand")
  @NotNull
  public String getBrand() {
    return brand;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * An optional display name of the brand
   **/
  
  @ApiModelProperty(value = "An optional display name of the brand")
  @JsonProperty("brandName")
  public String getBrandName() {
    return brandName;
  }
  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  /**
   * A description of the product
   **/
  
  @ApiModelProperty(required = true, value = "A description of the product")
  @JsonProperty("description")
  @NotNull
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate
   **/
  
  @ApiModelProperty(value = "The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate")
  @JsonProperty("effectiveFrom")
  public Date getEffectiveFrom() {
    return effectiveFrom;
  }
  public void setEffectiveFrom(Date effectiveFrom) {
    this.effectiveFrom = effectiveFrom;
  }

  /**
   * The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products
   **/
  
  @ApiModelProperty(value = "The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products")
  @JsonProperty("effectiveTo")
  public Date getEffectiveTo() {
    return effectiveTo;
  }
  public void setEffectiveTo(Date effectiveTo) {
    this.effectiveTo = effectiveTo;
  }

  /**
   * Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable
   **/
  
  @ApiModelProperty(required = true, value = "Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable")
  @JsonProperty("isTailored")
  @NotNull
  public Boolean isIsTailored() {
    return isTailored;
  }
  public void setIsTailored(Boolean isTailored) {
    this.isTailored = isTailored;
  }

  /**
   * The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)
   **/
  
  @ApiModelProperty(required = true, value = "The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)")
  @JsonProperty("lastUpdated")
  @NotNull
  public Date getLastUpdated() {
    return lastUpdated;
  }
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  /**
   * The display name of the product
   **/
  
  @ApiModelProperty(required = true, value = "The display name of the product")
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
  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("productCategory")
  @NotNull
  public BankingEnumProductCategory getProductCategory() {
    return productCategory;
  }
  public void setProductCategory(BankingEnumProductCategory productCategory) {
    this.productCategory = productCategory;
  }

  /**
   * A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.
   **/
  
  @ApiModelProperty(required = true, value = "A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.")
  @JsonProperty("productId")
  @NotNull
  public String getProductId() {
    return productId;
  }
  public void setProductId(String productId) {
    this.productId = productId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProduct bankingProduct = (BankingProduct) o;
    return Objects.equals(additionalInformation, bankingProduct.additionalInformation) &&
        Objects.equals(applicationUri, bankingProduct.applicationUri) &&
        Objects.equals(brand, bankingProduct.brand) &&
        Objects.equals(brandName, bankingProduct.brandName) &&
        Objects.equals(description, bankingProduct.description) &&
        Objects.equals(effectiveFrom, bankingProduct.effectiveFrom) &&
        Objects.equals(effectiveTo, bankingProduct.effectiveTo) &&
        Objects.equals(isTailored, bankingProduct.isTailored) &&
        Objects.equals(lastUpdated, bankingProduct.lastUpdated) &&
        Objects.equals(name, bankingProduct.name) &&
        Objects.equals(productCategory, bankingProduct.productCategory) &&
        Objects.equals(productId, bankingProduct.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInformation, applicationUri, brand, brandName, description, effectiveFrom, effectiveTo, isTailored, lastUpdated, name, productCategory, productId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProduct {\n");
    
    sb.append("    additionalInformation: ").append(toIndentedString(additionalInformation)).append("\n");
    sb.append("    applicationUri: ").append(toIndentedString(applicationUri)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    brandName: ").append(toIndentedString(brandName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    effectiveFrom: ").append(toIndentedString(effectiveFrom)).append("\n");
    sb.append("    effectiveTo: ").append(toIndentedString(effectiveTo)).append("\n");
    sb.append("    isTailored: ").append(toIndentedString(isTailored)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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

