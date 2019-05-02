

# BankingProductLendingRate

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalInfo** | **String** | Display text providing more information on the rate. |  [optional]
**additionalInfoUri** | **String** | Link to a web page with more information on this rate |  [optional]
**additionalValue** | **String** | Generic field containing additional information relevant to the lendingRateType specified. Whether mandatory or not is dependent on the value of lendingRateType |  [optional]
**applicationFrequency** | **String** | The period after which the calculated amount(s) (see calculationFrequency) are &#39;applied&#39; (i.e. debited or credited) to the account. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) |  [optional]
**calculationFrequency** | **String** | The period after which the rate is applied to the balance to calculate the amount due for the period. Calculation of the amount is often daily (as balances may change) but accumulated until the total amount is &#39;applied&#39; to the account (see applicationFrequency). Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) |  [optional]
**comparisonRate** | **String** | A comparison rate equivalent for this rate |  [optional]
**interestPaymentDue** | [**InterestPaymentDue**](InterestPaymentDue.md) |  |  [optional]
**lendingRateType** | [**LendingRateType**](LendingRateType.md) |  | 
**rate** | **String** | The rate to be applied | 
**tiers** | [**List&lt;BankingProductRateTier&gt;**](BankingProductRateTier.md) | Rate tiers applicable for this rate |  [optional]



