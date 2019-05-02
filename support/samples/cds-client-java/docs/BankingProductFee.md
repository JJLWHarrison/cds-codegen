

# BankingProductFee

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accrualFrequency** | **String** | The indicative frequency with which the fee is calculated on the account. Only applies if balanceRate or accruedRate is also present. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) |  [optional]
**accruedRate** | **String** | A fee rate calculated based on a proportion of the calculated interest accrued on the account. One of amount, balanceRate, transactionRate and accruedRate is mandatory |  [optional]
**additionalInfo** | **String** | Display text providing more information on the fee |  [optional]
**additionalInfoUri** | **String** | Link to a web page with more information on this fee |  [optional]
**additionalValue** | **String** | Generic field containing additional information relevant to the feeType specified. Whether mandatory or not is dependent on the value of feeType |  [optional]
**amount** | **String** | The amount charged for the fee. One of amount, balanceRate, transactionRate and accruedRate is mandatory | 
**balanceRate** | **String** | A fee rate calculated based on a proportion of the balance. One of amount, balanceRate, transactionRate and accruedRate is mandatory |  [optional]
**currency** | **String** | The currency the fee will be charged in. Assumes AUD if absent |  [optional]
**discounts** | [**List&lt;BankingProductDiscount&gt;**](BankingProductDiscount.md) | An optional list of discounts to this fee that may be available |  [optional]
**feeType** | [**FeeType**](FeeType.md) |  | 
**name** | **String** | Name of the fee | 
**transactionRate** | **String** | A fee rate calculated based on a proportion of a transaction. One of amount, balanceRate, transactionRate and accruedRate is mandatory |  [optional]



