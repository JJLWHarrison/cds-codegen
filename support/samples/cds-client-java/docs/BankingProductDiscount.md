

# BankingProductDiscount

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accruedRate** | **String** | A discount rate calculated based on a proportion of the calculated interest accrued on the account. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee |  [optional]
**additionalInfo** | **String** | Display text providing more information on the discount |  [optional]
**additionalInfoUri** | **String** | Link to a web page with more information on this discount |  [optional]
**additionalValue** | **String** | Generic field containing additional information relevant to the discountType specified. Whether mandatory or not is dependent on the value of discountType |  [optional]
**amount** | **String** | Value of the discount | 
**balanceRate** | **String** | A discount rate calculated based on a proportion of the balance. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee |  [optional]
**description** | **String** | Description of the discount | 
**discountType** | [**DiscountType**](DiscountType.md) |  | 
**eligibility** | [**List&lt;BankingProductDiscountEligibility&gt;**](BankingProductDiscountEligibility.md) | Eligibility constraints that apply to this discount |  [optional]
**feeRate** | **String** | A discount rate calculated based on a proportion of the fee to which this discount is attached. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory. Unless noted in additionalInfo, assumes the application and calculation frequency are the same as the corresponding fee |  [optional]
**transactionRate** | **String** | A discount rate calculated based on a proportion of a transaction. Note that the currency of the fee discount is expected to be the same as the currency of the fee itself. One of amount, balanceRate, transactionRate, accruedRate and feeRate is mandatory |  [optional]



