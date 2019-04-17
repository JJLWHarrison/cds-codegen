/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 * OpenAPI spec version: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package au.org.consumerdatastandards.model;

import java.util.Objects;
import java.util.Arrays;
import au.org.consumerdatastandards.model.BankingEnumProductCategory;
import au.org.consumerdatastandards.model.BankingProduct;
import au.org.consumerdatastandards.model.BankingProductAdditionalInformation;
import au.org.consumerdatastandards.model.BankingProductBundle;
import au.org.consumerdatastandards.model.BankingProductConstraint;
import au.org.consumerdatastandards.model.BankingProductDepositRate;
import au.org.consumerdatastandards.model.BankingProductEligibility;
import au.org.consumerdatastandards.model.BankingProductFeature;
import au.org.consumerdatastandards.model.BankingProductFee;
import au.org.consumerdatastandards.model.BankingProductLendingRate;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * BankingProductDetail
 */
public class BankingProductDetail {
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

  public static final String SERIALIZED_NAME_BUNDLES = "bundles";
  @SerializedName(SERIALIZED_NAME_BUNDLES)
  private List<BankingProductBundle> bundles = new ArrayList<BankingProductBundle>();

  public static final String SERIALIZED_NAME_CONSTRAINTS = "constraints";
  @SerializedName(SERIALIZED_NAME_CONSTRAINTS)
  private List<BankingProductConstraint> constraints = new ArrayList<BankingProductConstraint>();

  public static final String SERIALIZED_NAME_DEPOSIT_RATES = "depositRates";
  @SerializedName(SERIALIZED_NAME_DEPOSIT_RATES)
  private List<BankingProductDepositRate> depositRates = new ArrayList<BankingProductDepositRate>();

  public static final String SERIALIZED_NAME_ELIGIBILITY = "eligibility";
  @SerializedName(SERIALIZED_NAME_ELIGIBILITY)
  private List<BankingProductEligibility> eligibility = new ArrayList<BankingProductEligibility>();

  public static final String SERIALIZED_NAME_FEATURES = "features";
  @SerializedName(SERIALIZED_NAME_FEATURES)
  private List<BankingProductFeature> features = new ArrayList<BankingProductFeature>();

  public static final String SERIALIZED_NAME_FEES = "fees";
  @SerializedName(SERIALIZED_NAME_FEES)
  private List<BankingProductFee> fees = new ArrayList<BankingProductFee>();

  public static final String SERIALIZED_NAME_LENDING_RATES = "lendingRates";
  @SerializedName(SERIALIZED_NAME_LENDING_RATES)
  private List<BankingProductLendingRate> lendingRates = new ArrayList<BankingProductLendingRate>();

  public BankingProductDetail additionalInformation(BankingProductAdditionalInformation additionalInformation) {
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

  public BankingProductDetail applicationUri(String applicationUri) {
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

  public BankingProductDetail brand(String brand) {
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

  public BankingProductDetail brandName(String brandName) {
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

  public BankingProductDetail description(String description) {
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

  public BankingProductDetail effectiveFrom(OffsetDateTime effectiveFrom) {
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

  public BankingProductDetail effectiveTo(OffsetDateTime effectiveTo) {
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

  public BankingProductDetail isTailored(Boolean isTailored) {
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

  public BankingProductDetail lastUpdated(OffsetDateTime lastUpdated) {
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

  public BankingProductDetail name(String name) {
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

  public BankingProductDetail productCategory(BankingEnumProductCategory productCategory) {
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

  public BankingProductDetail productId(String productId) {
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

  public BankingProductDetail bundles(List<BankingProductBundle> bundles) {
    this.bundles = bundles;
    return this;
  }

  public BankingProductDetail addBundlesItem(BankingProductBundle bundlesItem) {
    if (this.bundles == null) {
      this.bundles = new ArrayList<BankingProductBundle>();
    }
    this.bundles.add(bundlesItem);
    return this;
  }

   /**
   * An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also
   * @return bundles
  **/
  @ApiModelProperty(value = "An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also")
  public List<BankingProductBundle> getBundles() {
    return bundles;
  }

  public void setBundles(List<BankingProductBundle> bundles) {
    this.bundles = bundles;
  }

  public BankingProductDetail constraints(List<BankingProductConstraint> constraints) {
    this.constraints = constraints;
    return this;
  }

  public BankingProductDetail addConstraintsItem(BankingProductConstraint constraintsItem) {
    if (this.constraints == null) {
      this.constraints = new ArrayList<BankingProductConstraint>();
    }
    this.constraints.add(constraintsItem);
    return this;
  }

   /**
   * Constraints on the application for or operation of the product such as minimum balances or limit thresholds
   * @return constraints
  **/
  @ApiModelProperty(value = "Constraints on the application for or operation of the product such as minimum balances or limit thresholds")
  public List<BankingProductConstraint> getConstraints() {
    return constraints;
  }

  public void setConstraints(List<BankingProductConstraint> constraints) {
    this.constraints = constraints;
  }

  public BankingProductDetail depositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
    return this;
  }

  public BankingProductDetail addDepositRatesItem(BankingProductDepositRate depositRatesItem) {
    if (this.depositRates == null) {
      this.depositRates = new ArrayList<BankingProductDepositRate>();
    }
    this.depositRates.add(depositRatesItem);
    return this;
  }

   /**
   * Interest rates available for deposits
   * @return depositRates
  **/
  @ApiModelProperty(value = "Interest rates available for deposits")
  public List<BankingProductDepositRate> getDepositRates() {
    return depositRates;
  }

  public void setDepositRates(List<BankingProductDepositRate> depositRates) {
    this.depositRates = depositRates;
  }

  public BankingProductDetail eligibility(List<BankingProductEligibility> eligibility) {
    this.eligibility = eligibility;
    return this;
  }

  public BankingProductDetail addEligibilityItem(BankingProductEligibility eligibilityItem) {
    if (this.eligibility == null) {
      this.eligibility = new ArrayList<BankingProductEligibility>();
    }
    this.eligibility.add(eligibilityItem);
    return this;
  }

   /**
   * Eligibility criteria for the product
   * @return eligibility
  **/
  @ApiModelProperty(value = "Eligibility criteria for the product")
  public List<BankingProductEligibility> getEligibility() {
    return eligibility;
  }

  public void setEligibility(List<BankingProductEligibility> eligibility) {
    this.eligibility = eligibility;
  }

  public BankingProductDetail features(List<BankingProductFeature> features) {
    this.features = features;
    return this;
  }

  public BankingProductDetail addFeaturesItem(BankingProductFeature featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<BankingProductFeature>();
    }
    this.features.add(featuresItem);
    return this;
  }

   /**
   * Array of features available for the product
   * @return features
  **/
  @ApiModelProperty(value = "Array of features available for the product")
  public List<BankingProductFeature> getFeatures() {
    return features;
  }

  public void setFeatures(List<BankingProductFeature> features) {
    this.features = features;
  }

  public BankingProductDetail fees(List<BankingProductFee> fees) {
    this.fees = fees;
    return this;
  }

  public BankingProductDetail addFeesItem(BankingProductFee feesItem) {
    if (this.fees == null) {
      this.fees = new ArrayList<BankingProductFee>();
    }
    this.fees.add(feesItem);
    return this;
  }

   /**
   * Fees applicable for the product
   * @return fees
  **/
  @ApiModelProperty(value = "Fees applicable for the product")
  public List<BankingProductFee> getFees() {
    return fees;
  }

  public void setFees(List<BankingProductFee> fees) {
    this.fees = fees;
  }

  public BankingProductDetail lendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
    return this;
  }

  public BankingProductDetail addLendingRatesItem(BankingProductLendingRate lendingRatesItem) {
    if (this.lendingRates == null) {
      this.lendingRates = new ArrayList<BankingProductLendingRate>();
    }
    this.lendingRates.add(lendingRatesItem);
    return this;
  }

   /**
   * Interest rates charged against lending balances
   * @return lendingRates
  **/
  @ApiModelProperty(value = "Interest rates charged against lending balances")
  public List<BankingProductLendingRate> getLendingRates() {
    return lendingRates;
  }

  public void setLendingRates(List<BankingProductLendingRate> lendingRates) {
    this.lendingRates = lendingRates;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductDetail bankingProductDetail = (BankingProductDetail) o;
    return Objects.equals(this.additionalInformation, bankingProductDetail.additionalInformation) &&
        Objects.equals(this.applicationUri, bankingProductDetail.applicationUri) &&
        Objects.equals(this.brand, bankingProductDetail.brand) &&
        Objects.equals(this.brandName, bankingProductDetail.brandName) &&
        Objects.equals(this.description, bankingProductDetail.description) &&
        Objects.equals(this.effectiveFrom, bankingProductDetail.effectiveFrom) &&
        Objects.equals(this.effectiveTo, bankingProductDetail.effectiveTo) &&
        Objects.equals(this.isTailored, bankingProductDetail.isTailored) &&
        Objects.equals(this.lastUpdated, bankingProductDetail.lastUpdated) &&
        Objects.equals(this.name, bankingProductDetail.name) &&
        Objects.equals(this.productCategory, bankingProductDetail.productCategory) &&
        Objects.equals(this.productId, bankingProductDetail.productId) &&
        Objects.equals(this.bundles, bankingProductDetail.bundles) &&
        Objects.equals(this.constraints, bankingProductDetail.constraints) &&
        Objects.equals(this.depositRates, bankingProductDetail.depositRates) &&
        Objects.equals(this.eligibility, bankingProductDetail.eligibility) &&
        Objects.equals(this.features, bankingProductDetail.features) &&
        Objects.equals(this.fees, bankingProductDetail.fees) &&
        Objects.equals(this.lendingRates, bankingProductDetail.lendingRates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInformation, applicationUri, brand, brandName, description, effectiveFrom, effectiveTo, isTailored, lastUpdated, name, productCategory, productId, bundles, constraints, depositRates, eligibility, features, fees, lendingRates);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductDetail {\n");
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
    sb.append("    bundles: ").append(toIndentedString(bundles)).append("\n");
    sb.append("    constraints: ").append(toIndentedString(constraints)).append("\n");
    sb.append("    depositRates: ").append(toIndentedString(depositRates)).append("\n");
    sb.append("    eligibility: ").append(toIndentedString(eligibility)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    lendingRates: ").append(toIndentedString(lendingRates)).append("\n");
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

