/*
 * Consumer Data Standards
 * Client Reference Implementation for the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 
 * NOTE: This class is auto generated by the cds-codegen package
 * https://github.com/ConsumerDataStandardsAustralia/cds-codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.reference.models;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import au.org.consumerdatastandards.reference.models.BankingProductDiscount;
import au.org.consumerdatastandards.reference.models.FeeType;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * BankingProductFee
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-04-11T19:35:49.725+10:00")
public class BankingProductFee {
    @SerializedName("accrualFrequency")
    private String accrualFrequency = null;

    @SerializedName("accruedRate")
    private String accruedRate = null;

    @SerializedName("additionalInfo")
    private String additionalInfo = null;

    @SerializedName("additionalInfoUri")
    private String additionalInfoUri = null;

    @SerializedName("additionalValue")
    private String additionalValue = null;

    @SerializedName("amount")
    private String amount = null;

    @SerializedName("balanceRate")
    private String balanceRate = null;

    @SerializedName("currency")
    private String currency = null;

    @SerializedName("discounts")
    private List<BankingProductDiscount> discounts = null;

    @SerializedName("feeType")
    private FeeType feeType = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("transactionRate")
    private String transactionRate = null;

    public BankingProductFee accrualFrequency(String accrualFrequency) {
        this.accrualFrequency = accrualFrequency;
        return this;
    }

    /**
     * The indicative frequency with which the fee is calculated on the account.
     * Only applies if balanceRate or accruedRate is also present. Formatted
     * according to [ISO 8601
     * Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
     * 
     * @return accrualFrequency
     **/
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
     * A fee rate calculated based on a proportion of the calculated interest
     * accrued on the account. One of amount, balanceRate, transactionRate and
     * accruedRate is mandatory
     * 
     * @return accruedRate
     **/
    @ApiModelProperty(value = "A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
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
     * 
     * @return additionalInfo
     **/
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
     * 
     * @return additionalInfoUri
     **/
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
     * Generic field containing additional information relevant to the feeType
     * specified. Whether mandatory or not is dependent on the value of feeType
     * 
     * @return additionalValue
     **/
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
     * The amount charged for the fee. One of amount, balanceRate, transactionRate
     * and accruedRate is mandatory
     * 
     * @return amount
     **/
    @ApiModelProperty(required = true, value = "The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
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
     * A fee rate calculated based on a proportion of the balance. One of amount,
     * balanceRate, transactionRate and accruedRate is mandatory
     * 
     * @return balanceRate
     **/
    @ApiModelProperty(value = "A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
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
     * 
     * @return currency
     **/
    @ApiModelProperty(value = "The currency the fee will be charged in. Assumes AUD if absent")
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
            this.discounts = new ArrayList<BankingProductDiscount>();
        }
        this.discounts.add(discountsItem);
        return this;
    }

    /**
     * An optional list of discounts to this fee that may be available
     * 
     * @return discounts
     **/
    @ApiModelProperty(value = "An optional list of discounts to this fee that may be available")
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
     * 
     * @return feeType
     **/
    @ApiModelProperty(required = true, value = "")
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
     * 
     * @return name
     **/
    @ApiModelProperty(required = true, value = "Name of the fee")
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
     * A fee rate calculated based on a proportion of a transaction. One of amount,
     * balanceRate, transactionRate and accruedRate is mandatory
     * 
     * @return transactionRate
     **/
    @ApiModelProperty(value = "A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
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
        return Objects.equals(this.accrualFrequency, bankingProductFee.accrualFrequency)
                && Objects.equals(this.accruedRate, bankingProductFee.accruedRate)
                && Objects.equals(this.additionalInfo, bankingProductFee.additionalInfo)
                && Objects.equals(this.additionalInfoUri, bankingProductFee.additionalInfoUri)
                && Objects.equals(this.additionalValue, bankingProductFee.additionalValue)
                && Objects.equals(this.amount, bankingProductFee.amount)
                && Objects.equals(this.balanceRate, bankingProductFee.balanceRate)
                && Objects.equals(this.currency, bankingProductFee.currency)
                && Objects.equals(this.discounts, bankingProductFee.discounts)
                && Objects.equals(this.feeType, bankingProductFee.feeType)
                && Objects.equals(this.name, bankingProductFee.name)
                && Objects.equals(this.transactionRate, bankingProductFee.transactionRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accrualFrequency, accruedRate, additionalInfo, additionalInfoUri, additionalValue, amount,
                balanceRate, currency, discounts, feeType, name, transactionRate);
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
