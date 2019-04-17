package au.org.consumerdatastandards.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.BankingProductDiscount;
import au.org.consumerdatastandards.models.FeeType;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import javax.validation.constraints.*;

public class BankingProductFee {

    private String accrualFrequency = null;
    private String accruedRate = null;
    private String additionalInfo = null;
    private String additionalInfoUri = null;
    private String additionalValue = null;
    private String amount = null;
    private String balanceRate = null;
    private String currency = null;
    private List<BankingProductDiscount> discounts = new ArrayList<BankingProductDiscount>();
    private FeeType feeType = null;
    private String name = null;
    private String transactionRate = null;

    /**
     * The indicative frequency with which the fee is calculated on the account.
     * Only applies if balanceRate or accruedRate is also present. Formatted
     * according to [ISO 8601
     * Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
     **/

    @ApiModelProperty(value = "The indicative frequency with which the fee is calculated on the account. Only applies if balanceRate or accruedRate is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
    @JsonProperty("accrualFrequency")
    public String getAccrualFrequency() {
        return accrualFrequency;
    }

    public void setAccrualFrequency(String accrualFrequency) {
        this.accrualFrequency = accrualFrequency;
    }

    /**
     * A fee rate calculated based on a proportion of the calculated interest
     * accrued on the account. One of amount, balanceRate, transactionRate and
     * accruedRate is mandatory
     **/

    @ApiModelProperty(value = "A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
    @JsonProperty("accruedRate")
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getAccruedRate() {
        return accruedRate;
    }

    public void setAccruedRate(String accruedRate) {
        this.accruedRate = accruedRate;
    }

    /**
     * Display text providing more information on the fee
     **/

    @ApiModelProperty(value = "Display text providing more information on the fee")
    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Link to a web page with more information on this fee
     **/

    @ApiModelProperty(value = "Link to a web page with more information on this fee")
    @JsonProperty("additionalInfoUri")
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    /**
     * Generic field containing additional information relevant to the feeType
     * specified. Whether mandatory or not is dependent on the value of feeType
     **/

    @ApiModelProperty(value = "Generic field containing additional information relevant to the feeType specified. Whether mandatory or not is dependent on the value of feeType")
    @JsonProperty("additionalValue")
    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    /**
     * The amount charged for the fee. One of amount, balanceRate, transactionRate
     * and accruedRate is mandatory
     **/

    @ApiModelProperty(required = true, value = "The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
    @JsonProperty("amount")
    @NotNull
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){2,16}")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * A fee rate calculated based on a proportion of the balance. One of amount,
     * balanceRate, transactionRate and accruedRate is mandatory
     **/

    @ApiModelProperty(value = "A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
    @JsonProperty("balanceRate")
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getBalanceRate() {
        return balanceRate;
    }

    public void setBalanceRate(String balanceRate) {
        this.balanceRate = balanceRate;
    }

    /**
     * The currency the fee will be charged in. Assumes AUD if absent
     **/

    @ApiModelProperty(value = "The currency the fee will be charged in. Assumes AUD if absent")
    @JsonProperty("currency")
    @Pattern(regexp = "^(AED|AFN|ALL|AMD|ANG|AOA|ARS|AUD|AWG|AZN|BAM|BBD|BDT|BGN|BHD|BIF|BMD|BND|BOB|BOV|BRL|BSD|BTN|BWP|BYN|BZD|CAD|CDF|CHE|CHF|CHW|CLF|CLP|CNY|COP|COU|CRC|CUC|CUP|CVE|CZK|DJF|DKK|DOP|DZD|EGP|ERN|ETB|EUR|FJD|FKP|GBP|GEL|GHS|GIP|GMD|GNF|GTQ|GYD|HKD|HNL|HRK|HTG|HUF|IDR|ILS|INR|IQD|IRR|ISK|JMD|JOD|JPY|KES|KGS|KHR|KMF|KPW|KRW|KWD|KYD|KZT|LAK|LBP|LKR|LRD|LSL|LYD|MAD|MDL|MGA|MKD|MMK|MNT|MOP|MRU|MUR|MVR|MWK|MXN|MXV|MYR|MZN|NAD|NGN|NIO|NOK|NPR|NZD|OMR|PAB|PEN|PGK|PHP|PKR|PLN|PYG|QAR|RON|RSD|RUB|RWF|SAR|SBD|SCR|SDG|SEK|SGD|SHP|SLL|SOS|SRD|SSP|STN|SVC|SYP|SZL|THB|TJS|TMT|TND|TOP|TRY|TTD|TWD|TZS|UAH|UGX|USD|USN|UYI|UYU|UYW|UZS|VES|VND|VUV|WST|XAF|XAG|XAU|XBA|XBB|XBC|XBD|XCD|XDR|XOF|XPD|XPF|XPT|XSU|XTS|XUA|XXX|YER|ZAR|ZMW|ZWL)$")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * An optional list of discounts to this fee that may be available
     **/

    @ApiModelProperty(value = "An optional list of discounts to this fee that may be available")
    @JsonProperty("discounts")
    public List<BankingProductDiscount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<BankingProductDiscount> discounts) {
        this.discounts = discounts;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("feeType")
    @NotNull
    public FeeType getFeeType() {
        return feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    /**
     * Name of the fee
     **/

    @ApiModelProperty(required = true, value = "Name of the fee")
    @JsonProperty("name")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * A fee rate calculated based on a proportion of a transaction. One of amount,
     * balanceRate, transactionRate and accruedRate is mandatory
     **/

    @ApiModelProperty(value = "A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory")
    @JsonProperty("transactionRate")
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getTransactionRate() {
        return transactionRate;
    }

    public void setTransactionRate(String transactionRate) {
        this.transactionRate = transactionRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductFee bankingProductFee = (BankingProductFee) o;
        return Objects.equals(accrualFrequency, bankingProductFee.accrualFrequency)
                && Objects.equals(accruedRate, bankingProductFee.accruedRate)
                && Objects.equals(additionalInfo, bankingProductFee.additionalInfo)
                && Objects.equals(additionalInfoUri, bankingProductFee.additionalInfoUri)
                && Objects.equals(additionalValue, bankingProductFee.additionalValue)
                && Objects.equals(amount, bankingProductFee.amount)
                && Objects.equals(balanceRate, bankingProductFee.balanceRate)
                && Objects.equals(currency, bankingProductFee.currency)
                && Objects.equals(discounts, bankingProductFee.discounts)
                && Objects.equals(feeType, bankingProductFee.feeType) && Objects.equals(name, bankingProductFee.name)
                && Objects.equals(transactionRate, bankingProductFee.transactionRate);
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
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
