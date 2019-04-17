package au.org.consumerdatastandards.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

import au.org.consumerdatastandards.models.BankingProductDiscountEligibility;
import au.org.consumerdatastandards.models.DiscountType;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import javax.validation.constraints.*;

public class BankingProductDiscount {

    private String accruedRate = null;
    private String additionalInfo = null;
    private String additionalInfoUri = null;
    private String additionalValue = null;
    private String amount = null;
    private String balanceRate = null;
    private String description = null;
    private DiscountType discountType = null;
    private List<BankingProductDiscountEligibility> eligibility = new ArrayList<BankingProductDiscountEligibility>();
    private String feeRate = null;
    private String transactionRate = null;

    /**
     * A discount rate calculated based on a proportion of the calculated interest
     * accrued on the account. Note that the currency of the fee discount is
     * expected to be the same as the currency of the fee itself. One of amount,
     * balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless
     * noted in additionalInfo, assumes the application and calculation frequency
     * are the same as the corresponding fee
     **/

    @ApiModelProperty(value = "A discount rate calculated based on a proportion of the calculated interest accrued on the account. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee")
    @JsonProperty("accruedRate")
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getAccruedRate() {
        return accruedRate;
    }

    public void setAccruedRate(String accruedRate) {
        this.accruedRate = accruedRate;
    }

    /**
     * Display text providing more information on the discount
     **/

    @ApiModelProperty(value = "Display text providing more information on the discount")
    @JsonProperty("additionalInfo")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * Link to a web page with more information on this discount
     **/

    @ApiModelProperty(value = "Link to a web page with more information on this discount")
    @JsonProperty("additionalInfoUri")
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    /**
     * Generic field containing additional information relevant to the discountType
     * specified. Whether mandatory or not is dependent on the value of discountType
     **/

    @ApiModelProperty(value = "Generic field containing additional information relevant to the discountType specified. Whether mandatory or not is dependent on the value of discountType")
    @JsonProperty("additionalValue")
    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    /**
     * Value of the discount
     **/

    @ApiModelProperty(required = true, value = "Value of the discount")
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
     * A discount rate calculated based on a proportion of the balance. Note that
     * the currency of the fee discount is expected to be the same as the currency
     * of the fee itself. One of amount, balanceRate, transactionRate, accruedRate
     * and feeRate is mandatory. Unless noted in additionalInfo, assumes the
     * application and calculation frequency are the same as the corresponding fee
     **/

    @ApiModelProperty(value = "A discount rate calculated based on a proportion of the balance. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee")
    @JsonProperty("balanceRate")
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getBalanceRate() {
        return balanceRate;
    }

    public void setBalanceRate(String balanceRate) {
        this.balanceRate = balanceRate;
    }

    /**
     * Description of the discount
     **/

    @ApiModelProperty(required = true, value = "Description of the discount")
    @JsonProperty("description")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     **/

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("discountType")
    @NotNull
    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    /**
     * Eligibility constraints that apply to this discount
     **/

    @ApiModelProperty(value = "Eligibility constraints that apply to this discount")
    @JsonProperty("eligibility")
    public List<BankingProductDiscountEligibility> getEligibility() {
        return eligibility;
    }

    public void setEligibility(List<BankingProductDiscountEligibility> eligibility) {
        this.eligibility = eligibility;
    }

    /**
     * A discount rate calculated based on a proportion of the fee to which this
     * discount is attached. Note that the currency of the fee discount is expected
     * to be the same as the currency of the fee itself. One of amount, balanceRate,
     * transactionRate, accruedRate and feeRate is mandatory. Unless noted in
     * additionalInfo, assumes the application and calculation frequency are the
     * same as the corresponding fee
     **/

    @ApiModelProperty(value = "A discount rate calculated based on a proportion of the fee to which this discount is attached. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee")
    @JsonProperty("feeRate")
    @Pattern(regexp = "^\\-?(\\d+){1,16}\\.(\\d+){1,16}")
    public String getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate;
    }

    /**
     * A discount rate calculated based on a proportion of a transaction. Note that
     * the currency of the fee discount is expected to be the same as the currency
     * of the fee itself. One of amount, balanceRate, transactionRate, accruedRate
     * and feeRate is mandatory
     **/

    @ApiModelProperty(value = "A discount rate calculated based on a proportion of a transaction. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory")
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
        BankingProductDiscount bankingProductDiscount = (BankingProductDiscount) o;
        return Objects.equals(accruedRate, bankingProductDiscount.accruedRate)
                && Objects.equals(additionalInfo, bankingProductDiscount.additionalInfo)
                && Objects.equals(additionalInfoUri, bankingProductDiscount.additionalInfoUri)
                && Objects.equals(additionalValue, bankingProductDiscount.additionalValue)
                && Objects.equals(amount, bankingProductDiscount.amount)
                && Objects.equals(balanceRate, bankingProductDiscount.balanceRate)
                && Objects.equals(description, bankingProductDiscount.description)
                && Objects.equals(discountType, bankingProductDiscount.discountType)
                && Objects.equals(eligibility, bankingProductDiscount.eligibility)
                && Objects.equals(feeRate, bankingProductDiscount.feeRate)
                && Objects.equals(transactionRate, bankingProductDiscount.transactionRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accruedRate, additionalInfo, additionalInfoUri, additionalValue, amount, balanceRate,
                description, discountType, eligibility, feeRate, transactionRate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankingProductDiscount {\n");

        sb.append("    accruedRate: ").append(toIndentedString(accruedRate)).append("\n");
        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
        sb.append("    additionalValue: ").append(toIndentedString(additionalValue)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    balanceRate: ").append(toIndentedString(balanceRate)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
        sb.append("    eligibility: ").append(toIndentedString(eligibility)).append("\n");
        sb.append("    feeRate: ").append(toIndentedString(feeRate)).append("\n");
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
