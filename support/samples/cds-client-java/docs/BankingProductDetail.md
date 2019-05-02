

# BankingProductDetail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**additionalInformation** | [**BankingProductAdditionalInformation**](BankingProductAdditionalInformation.md) |  |  [optional]
**applicationUri** | **String** | A link to the an application web page where this product can be applied for. |  [optional]
**brand** | **String** | A label of the brand for the product. Able to be used for filtering. For data providers with single brands this value is still required | 
**brandName** | **String** | An optional display name of the brand |  [optional]
**description** | **String** | A description of the product | 
**effectiveFrom** | [**OffsetDateTime**](OffsetDateTime.md) | The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate |  [optional]
**effectiveTo** | [**OffsetDateTime**](OffsetDateTime.md) | The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products |  [optional]
**isTailored** | **Boolean** | Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable | 
**lastUpdated** | [**OffsetDateTime**](OffsetDateTime.md) | The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered) | 
**name** | **String** | The display name of the product | 
**productCategory** | [**BankingEnumProductCategory**](BankingEnumProductCategory.md) |  | 
**productId** | **String** | A provider specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines. | 
**bundles** | [**List&lt;BankingProductBundle&gt;**](BankingProductBundle.md) | An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also |  [optional]
**constraints** | [**List&lt;BankingProductConstraint&gt;**](BankingProductConstraint.md) | Constraints on the application for or operation of the product such as minimum balances or limit thresholds |  [optional]
**depositRates** | [**List&lt;BankingProductDepositRate&gt;**](BankingProductDepositRate.md) | Interest rates available for deposits |  [optional]
**eligibility** | [**List&lt;BankingProductEligibility&gt;**](BankingProductEligibility.md) | Eligibility criteria for the product |  [optional]
**features** | [**List&lt;BankingProductFeature&gt;**](BankingProductFeature.md) | Array of features available for the product |  [optional]
**fees** | [**List&lt;BankingProductFee&gt;**](BankingProductFee.md) | Fees applicable for the product |  [optional]
**lendingRates** | [**List&lt;BankingProductLendingRate&gt;**](BankingProductLendingRate.md) | Interest rates charged against lending balances |  [optional]



