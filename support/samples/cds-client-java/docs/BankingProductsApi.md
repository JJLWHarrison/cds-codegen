# BankingApIsApi

All URIs are relative to *https://data.provider.com.au/cds-au/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProductDetail**](BankingProductsApi.md#getProductDetail) | **GET** /banking/products/{productId} | Get Product Detail
[**listProducts**](BankingProductsApi.md#listProducts) | **GET** /banking/products | Get Products


<a name="getProductDetail"></a>
# **getProductDetail**
> ResponseBankingProductById getProductDetail(productId)

Get Product Detail

Obtain detailed information on a single product offered openly to the market

### Example
```java
// Import classes:
//import au.org.consumerdatastandards.ApiException;
BankingProductsApi


BankingApIsApi apiInstance = new BankingApIsApi();
String productId = "productId_example"; // String | ID of the specific product requested
try {
    ResponseBankingProductById result = apiInstance.getProductDetail(productId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankingApIsApi#getProductDetail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productId** | **String**| ID of the specific product requested |

### Return type

[**ResponseBankingProductById**](ResponseBankingProductById.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listProducts"></a>
# **listProducts**
> ResponseBankingProductList listProducts(effective, updatedSince, brand, productCategory, page, pageSize)

Get Products

Obtain a list of products that are currently openly offered to the market  Note that the results returned by this end point are expected to be ordered according to updated-since  ### Conventions In the product reference payloads there are a number of recurring conventions that are explained here, in one place.  #### Arrays Of Features  In the product detail payload there are a number of arrays articulating generic features, constraints, prices, etc. The intent of these arrays is as follows:  - Each element in an array has the same structure so that clients can reliably interpret the payloads - Each element as a type element that is an enumeration of the specific aspect of a product being described, such as types of fees. - Each element has a field name additionalValue. This is a generic field with contents that will vary based on the type of object being described. The contents of this field for the ADDITIONAL_CARDS feature is the number of cards allowed while the contents of this field for the MAX_LIMIT constraint would be the maximum credit limit allowed for the product. - An element in these arrays of the same type may appear more than once. For instance, a product may offer two separate loyalty programs that the customer can select from. A fixed term mortgage may have different rates for different term lengths. - An element in these arrays may contain an additionalInfo and additionalInfoUri field. The additionalInfo field is used to provide displayable text clarifying the purpose of the element in some way when the product is presented to a customer. The additionalInfoUri provides a link to externally hosted information specifically relevant to that feature of the product. - Depending on the type of data being represented there may be additional specific fields.  #### URIs To More Information  As the complexities and nuances of a financial product can not easily be fully expressed in a data structure without a high degree of complexity it is necessary to provide additional reference information that a potential customer can access so that they are fully informed of the features and implications of the product. The payloads for product reference therefore contain numerous fields that are provided to allow the product provider to describe the product more fully using a web page hosted on their on channels.  These URIs do not need to all link to different pages. If desired, they can all link to a single hosted page and use difference HTML anchors to focus on a specific topic such as eligibility or fees.  #### Linkage To Accounts From the moment that a customer applies for a product and an account is created the account and the product that spawned it will diverge.  Rates and features of the product may change and a discount may be negotiated for the account.  For this reason, while productCategory is a common field between accounts and products, there is no specific ID that can be used to link an account to a product within the regime.  Similarly, many of the fields and objects in the product payload will appear in the account detail payload but the structures and semantics are not identical as one refers to a product that can potentially be originated and one refers to an account that actual has been instantiated and created along with the associated decisions inherent in that process.  #### Dates It is expected that data consumers needing this data will call relatively frequently to ensure the data they have is representative of the current offering from a bank.  To minimise the volume and frequency of these calls the ability to set a lastUpdated field with the date and time of the last update to this product is included.  A call for a list of products can then be filtered to only return products that have been updated since the last time that data was obtained using the updated-since query parameter.  In addition, the concept of effective date and time has also been included.  This allows for a product to be marked for obsolescence, or introduction, from a certain time without the need for an update to show that a product has been changed.  The inclusion of these dates also removes the need to represent deleted products in the payload.  Products that are no long offered can be marked not effective for a few weeks before they are then removed from the product set as an option entirely.

### Example
```java
// Import classes:
//import au.org.consumerdatastandards.ApiException;
//import au.org.consumerdatastandards.api.BankingApIsApi;


BankingApIsApi apiInstance = new BankingApIsApi();
String effective = "CURRENT"; // String | Allows for the filtering of products based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &#39;CURRENT&#39;
OffsetDateTime updatedSince = new OffsetDateTime(); // OffsetDateTime | Only include products that have been updated after the specified date and time. If absent defaults to include all products
String brand = "brand_example"; // String | Filter results based on a specific brand
String productCategory = "productCategory_example"; // String | Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned.
Integer page = 1; // Integer | Page of results to request (standard pagination)
Integer pageSize = 25; // Integer | Page size to request. Default is 25 (standard pagination)
try {
    ResponseBankingProductList result = apiInstance.listProducts(effective, updatedSince, brand, productCategory, page, pageSize);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BankingApIsApi#listProducts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **effective** | **String**| Allows for the filtering of products based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &amp;#39;CURRENT&amp;#39; | [optional] [default to CURRENT] [enum: ALL, CURRENT, FUTURE]
 **updatedSince** | **OffsetDateTime**| Only include products that have been updated after the specified date and time. If absent defaults to include all products | [optional]
 **brand** | **String**| Filter results based on a specific brand | [optional]
 **productCategory** | **String**| Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. | [optional] [enum: CRED_AND_CHRG_CARDS, LEASES, MARGIN_LOANS, PERS_LOANS, REGULATED_TRUST_ACCOUNTS, RESIDENTIAL_MORTGAGES, TERM_DEPOSITS, TRADE_FINANCE, TRANS_AND_SAVINGS_ACCOUNTS, TRAVEL_CARDS]
 **page** | **Integer**| Page of results to request (standard pagination) | [optional] [default to 1]
 **pageSize** | **Integer**| Page size to request. Default is 25 (standard pagination) | [optional] [default to 25]

### Return type

[**ResponseBankingProductList**](ResponseBankingProductList.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

