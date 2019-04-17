

# BankingProductRateTierSubTier

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**applicabilityConditions** | [**BankingProductRateCondition**](BankingProductRateCondition.md) |  |  [optional]
**maximumValue** | [**BigDecimal**](BigDecimal.md) | The number of tierUnitOfMeasure units that form the upper bound of the tier or band. For a tier with a discrete value (as opposed to a range of values e.g. 1 month) this must be the same as tierValueMinimum. Where this is the same as the tierValueMinimum value of the next-higher tier the referenced tier should be exclusive of this value. For example a term deposit of 2 months falls into the upper tier of the following tiers: (1 – 2 months, 2 – 3 months) | 
**minimumValue** | [**BigDecimal**](BigDecimal.md) | The number of tierUnitOfMeasure units that form the lower bound of the tier. The tier should be inclusive of this value | 
**name** | **String** | A display name for the tier | 
**rateApplicationMethod** | [**RateApplicationMethod**](RateApplicationMethod.md) |  |  [optional]
**unitOfMeasure** | [**UnitOfMeasure**](UnitOfMeasure.md) |  | 



