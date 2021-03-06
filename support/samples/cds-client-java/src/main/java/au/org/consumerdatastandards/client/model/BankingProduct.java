/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * BankingProduct
 */
public class BankingProduct {
  public static final String SERIALIZED_NAME_ADDITIONAL_INFORMATION = "additionalInformation";
  @SerializedName(SERIALIZED_NAME_ADDITIONAL_INFORMATION)
  private BankingProductAdditionalInformation additionalInformation = null;

  public static final String SERIALIZED_NAME_APPLICATION_URI = "applicationUri";
  @SerializedName(SERIALIZED_NAME_APPLICATION_URI)
  private String applicationUri;

  public static final String SERIALIZED_NAME_BRAND = "brand";
  @SerializedName(SERIALIZED_NAME_BRAND)
  private String brand;

  public static final String SERIALIZED_NAME_BRAND_NAME = "brandName";
  @SerializedName(SERIALIZED_NAME_BRAND_NAME)
  private String brandName;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_EFFECTIVE_FROM = "effectiveFrom";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_FROM)
  private OffsetDateTime effectiveFrom;

  public static final String SERIALIZED_NAME_EFFECTIVE_TO = "effectiveTo";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_TO)
  private OffsetDateTime effectiveTo;

  public static final String SERIALIZED_NAME_IS_TAILORED = "isTailored";
  @SerializedName(SERIALIZED_NAME_IS_TAILORED)
  private Boolean isTailored;

  public static final String SERIALIZED_NAME_LAST_UPDATED = "lastUpdated";
  @SerializedName(SERIALIZED_NAME_LAST_UPDATED)
  private OffsetDateTime lastUpdated;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_PRODUCT_CATEGORY = "productCategory";
  @SerializedName(SERIALIZED_NAME_PRODUCT_CATEGORY)
  private BankingEnumProductCategory productCategory;

  public static final String SERIALIZED_NAME_PRODUCT_ID = "productId";
  @SerializedName(SERIALIZED_NAME_PRODUCT_ID)
  private String productId;

  public BankingProduct additionalInformation(BankingProductAdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
    return this;
  }

   /**
   * Get additionalInformation
   * @return additionalInformation
  **/
  @ApiModelProperty(value = "")
  public BankingProductAdditionalInformation getAdditionalInformation() {
    return additionalInformation;
  }

  public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  public BankingProduct applicationUri(String applicationUri) {
    this.applicationUri = applicationUri;
    return this;
  }

   /**
   * A link to the an application web page where this product can be applied for.
   * @return applicationUri
  **/
  @ApiModelProperty(value = "A link to the an application web page where this product can be applied for.")
  public String getApplicationUri() {
    return applicationUri;
  }

  public void setApplicationUri(String applicationUri) {
    this.applicationUri = applicationUri;
  }

  public BankingProduct brand(String brand) {
    this.brand = brand;
    return this;
  }

   /**
   * A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required
   * @return brand
  **/
  @ApiModelProperty(required = true, value = "A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required")
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public BankingProduct brandName(String brandName) {
    this.brandName = brandName;
    return this;
  }

   /**
   * An optional display name of the brand
   * @return brandName
  **/
  @ApiModelProperty(value = "An optional display name of the brand")
  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public BankingProduct description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A description of the product
   * @return description
  **/
  @ApiModelProperty(required = true, value = "A description of the product")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BankingProduct effectiveFrom(OffsetDateTime effectiveFrom) {
    this.effectiveFrom = effectiveFrom;
    return this;
  }

   /**
   * The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate
   * @return effectiveFrom
  **/
  @ApiModelProperty(value = "The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate")
  public OffsetDateTime getEffectiveFrom() {
    return effectiveFrom;
  }

  public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
    this.effectiveFrom = effectiveFrom;
  }

  public BankingProduct effectiveTo(OffsetDateTime effectiveTo) {
    this.effectiveTo = effectiveTo;
    return this;
  }

   /**
   * The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products
   * @return effectiveTo
  **/
  @ApiModelProperty(value = "The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products")
  public OffsetDateTime getEffectiveTo() {
    return effectiveTo;
  }

  public void setEffectiveTo(OffsetDateTime effectiveTo) {
    this.effectiveTo = effectiveTo;
  }

  public BankingProduct isTailored(Boolean isTailored) {
    this.isTailored = isTailored;
    return this;
  }

   /**
   * Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable
   * @return isTailored
  **/
  @ApiModelProperty(required = true, value = "Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable")
  public Boolean getIsTailored() {
    return isTailored;
  }

  public void setIsTailored(Boolean isTailored) {
    this.isTailored = isTailored;
  }

  public BankingProduct lastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)
   * @return lastUpdated
  **/
  @ApiModelProperty(required = true, value = "The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)")
  public OffsetDateTime getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(OffsetDateTime lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public BankingProduct name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The display name of the product
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The display name of the product")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProduct productCategory(BankingEnumProductCategory productCategory) {
    this.productCategory = productCategory;
    return this;
  }

   /**
   * Get productCategory
   * @return productCategory
  **/
  @ApiModelProperty(required = true, value = "")
  public BankingEnumProductCategory getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(BankingEnumProductCategory productCategory) {
    this.productCategory = productCategory;
  }

  public BankingProduct productId(String productId) {
    this.productId = productId;
    return this;
  }

   /**
   * A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.
   * @return productId
  **/
  @ApiModelProperty(required = true, value = "A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.")
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProduct bankingProduct = (BankingProduct) o;
    return Objects.equals(this.additionalInformation, bankingProduct.additionalInformation) &&
        Objects.equals(this.applicationUri, bankingProduct.applicationUri) &&
        Objects.equals(this.brand, bankingProduct.brand) &&
        Objects.equals(this.brandName, bankingProduct.brandName) &&
        Objects.equals(this.description, bankingProduct.description) &&
        Objects.equals(this.effectiveFrom, bankingProduct.effectiveFrom) &&
        Objects.equals(this.effectiveTo, bankingProduct.effectiveTo) &&
        Objects.equals(this.isTailored, bankingProduct.isTailored) &&
        Objects.equals(this.lastUpdated, bankingProduct.lastUpdated) &&
        Objects.equals(this.name, bankingProduct.name) &&
        Objects.equals(this.productCategory, bankingProduct.productCategory) &&
        Objects.equals(this.productId, bankingProduct.productId);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

