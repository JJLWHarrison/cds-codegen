package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class BankingProductFee   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer productFeeId;

  @JsonProperty("accrualFrequency")
  private String accrualFrequency;

  @JsonProperty("accruedRate")
  private String accruedRate;

  @JsonProperty("additionalInfo")
  private String additionalInfo;

  @JsonProperty("additionalInfoUri")
  private String additionalInfoUri;

  @JsonProperty("additionalValue")
  private String additionalValue;

  @JsonProperty("amount")
  private String amount;

  @JsonProperty("balanceRate")
  private String balanceRate;

  @JsonProperty("currency")
  private String currency;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "product_fee_discounts",
      joinColumns = @JoinColumn(name = "product_fee_id"),
      inverseJoinColumns = @JoinColumn(name = "product_discount_id"))
  @JsonProperty("discounts")
  @Valid
  private List<BankingProductDiscount> discounts = null;

  @JsonProperty("feeType")
  private FeeType feeType;

  @JsonProperty("name")
  private String name;

  @JsonProperty("transactionRate")
  private String transactionRate;

  public Integer getProductFeeId() {
    return productFeeId;
  }

  public void setProductFeeId(Integer productFeeId) {
    this.productFeeId = productFeeId;
  }

  public BankingProductFee accrualFrequency(String accrualFrequency) {
    this.accrualFrequency = accrualFrequency;
    return this;
  }

  /**
   * The indicative frequency with which the fee is calculated on the account. Only applies if balanceRate or accruedRate is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
   * @return accrualFrequency
  */
  @ApiModelProperty(value = "The indicative frequency with which the fee is calculated on the account. Only applies if balanceRate or accruedRate is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")


  public String getAccrualFrequency() {
    return accrualFrequency;
  }

  public void setAccrualFrequency(String accrualFrequency) {
    this.accrualFrequency = accrualFrequency;
  }

  public BankingProductFee accruedRate(String accruedRate) {
    this.accruedRate = accruedRate;
    return this;
  }

  /**
   * A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return accruedRate
  */
  @ApiModelProperty(value = "A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory")

@Pattern(regexp="^\\-?(\\d+){1,16}\\.(\\d+){1,16}") 
  public String getAccruedRate() {
    return accruedRate;
  }

  public void setAccruedRate(String accruedRate) {
    this.accruedRate = accruedRate;
  }

  public BankingProductFee additionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  /**
   * Display text providing more information on the fee
   * @return additionalInfo
  */
  @ApiModelProperty(value = "Display text providing more information on the fee")


  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public BankingProductFee additionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
    return this;
  }

  /**
   * Link to a web page with more information on this fee
   * @return additionalInfoUri
  */
  @ApiModelProperty(value = "Link to a web page with more information on this fee")


  public String getAdditionalInfoUri() {
    return additionalInfoUri;
  }

  public void setAdditionalInfoUri(String additionalInfoUri) {
    this.additionalInfoUri = additionalInfoUri;
  }

  public BankingProductFee additionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
    return this;
  }

  /**
   * Generic field containing additional information relevant to the feeType specified. Whether mandatory or not is dependent on the value of feeType
   * @return additionalValue
  */
  @ApiModelProperty(value = "Generic field containing additional information relevant to the feeType specified. Whether mandatory or not is dependent on the value of feeType")


  public String getAdditionalValue() {
    return additionalValue;
  }

  public void setAdditionalValue(String additionalValue) {
    this.additionalValue = additionalValue;
  }

  public BankingProductFee amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return amount
  */
  @ApiModelProperty(required = true, value = "The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
  @NotNull

@Pattern(regexp="^\\-?(\\d+){1,16}\\.(\\d+){2,16}") 
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public BankingProductFee balanceRate(String balanceRate) {
    this.balanceRate = balanceRate;
    return this;
  }

  /**
   * A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return balanceRate
  */
  @ApiModelProperty(value = "A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory")

@Pattern(regexp="^\\-?(\\d+){1,16}\\.(\\d+){1,16}") 
  public String getBalanceRate() {
    return balanceRate;
  }

  public void setBalanceRate(String balanceRate) {
    this.balanceRate = balanceRate;
  }

  public BankingProductFee currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * The currency the fee will be charged in. Assumes AUD if absent
   * @return currency
  */
  @ApiModelProperty(value = "The currency the fee will be charged in. Assumes AUD if absent")

@Pattern(regexp="^(AED|AFN|ALL|AMD|ANG|AOA|ARS|AUD|AWG|AZN|BAM|BBD|BDT|BGN|BHD|BIF|BMD|BND|BOB|BOV|BRL|BSD|BTN|BWP|BYN|BZD|CAD|CDF|CHE|CHF|CHW|CLF|CLP|CNY|COP|COU|CRC|CUC|CUP|CVE|CZK|DJF|DKK|DOP|DZD|EGP|ERN|ETB|EUR|FJD|FKP|GBP|GEL|GHS|GIP|GMD|GNF|GTQ|GYD|HKD|HNL|HRK|HTG|HUF|IDR|ILS|INR|IQD|IRR|ISK|JMD|JOD|JPY|KES|KGS|KHR|KMF|KPW|KRW|KWD|KYD|KZT|LAK|LBP|LKR|LRD|LSL|LYD|MAD|MDL|MGA|MKD|MMK|MNT|MOP|MRU|MUR|MVR|MWK|MXN|MXV|MYR|MZN|NAD|NGN|NIO|NOK|NPR|NZD|OMR|PAB|PEN|PGK|PHP|PKR|PLN|PYG|QAR|RON|RSD|RUB|RWF|SAR|SBD|SCR|SDG|SEK|SGD|SHP|SLL|SOS|SRD|SSP|STN|SVC|SYP|SZL|THB|TJS|TMT|TND|TOP|TRY|TTD|TWD|TZS|UAH|UGX|USD|USN|UYI|UYU|UYW|UZS|VES|VND|VUV|WST|XAF|XAG|XAU|XBA|XBB|XBC|XBD|XCD|XDR|XOF|XPD|XPF|XPT|XSU|XTS|XUA|XXX|YER|ZAR|ZMW|ZWL)$") 
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BankingProductFee discounts(List<BankingProductDiscount> discounts) {
    this.discounts = discounts;
    return this;
  }

  public BankingProductFee addDiscountsItem(BankingProductDiscount discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

  /**
   * An optional list of discounts to this fee that may be available
   * @return discounts
  */
  @ApiModelProperty(value = "An optional list of discounts to this fee that may be available")

  @Valid

  public List<BankingProductDiscount> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<BankingProductDiscount> discounts) {
    this.discounts = discounts;
  }

  public BankingProductFee feeType(FeeType feeType) {
    this.feeType = feeType;
    return this;
  }

  /**
   * Get feeType
   * @return feeType
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public FeeType getFeeType() {
    return feeType;
  }

  public void setFeeType(FeeType feeType) {
    this.feeType = feeType;
  }

  public BankingProductFee name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the fee
   * @return name
  */
  @ApiModelProperty(required = true, value = "Name of the fee")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BankingProductFee transactionRate(String transactionRate) {
    this.transactionRate = transactionRate;
    return this;
  }

  /**
   * A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory
   * @return transactionRate
  */
  @ApiModelProperty(value = "A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory")

@Pattern(regexp="^\\-?(\\d+){1,16}\\.(\\d+){1,16}") 
  public String getTransactionRate() {
    return transactionRate;
  }

  public void setTransactionRate(String transactionRate) {
    this.transactionRate = transactionRate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankingProductFee bankingProductFee = (BankingProductFee) o;
    return Objects.equals(this.accrualFrequency, bankingProductFee.accrualFrequency) &&
        Objects.equals(this.accruedRate, bankingProductFee.accruedRate) &&
        Objects.equals(this.additionalInfo, bankingProductFee.additionalInfo) &&
        Objects.equals(this.additionalInfoUri, bankingProductFee.additionalInfoUri) &&
        Objects.equals(this.additionalValue, bankingProductFee.additionalValue) &&
        Objects.equals(this.amount, bankingProductFee.amount) &&
        Objects.equals(this.balanceRate, bankingProductFee.balanceRate) &&
        Objects.equals(this.currency, bankingProductFee.currency) &&
        Objects.equals(this.discounts, bankingProductFee.discounts) &&
        Objects.equals(this.feeType, bankingProductFee.feeType) &&
        Objects.equals(this.name, bankingProductFee.name) &&
        Objects.equals(this.transactionRate, bankingProductFee.transactionRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accrualFrequency, accruedRate, additionalInfo, additionalInfoUri, additionalValue, amount, balanceRate, currency, discounts, feeType, name, transactionRate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankingProductFee {\n");
    
    sb.append("    accrualFrequency: ").append(toIndentedString(accrualFrequency)).append("\n");
    sb.append("    accruedRate: ").append(toIndentedString(accruedRate)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
    sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    balanceRate: ").append(toIndentedString(balanceRate)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    feeType: ").append(toIndentedString(feeType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    transactionRate: ").append(toIndentedString(transactionRate)).append("\n");
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

