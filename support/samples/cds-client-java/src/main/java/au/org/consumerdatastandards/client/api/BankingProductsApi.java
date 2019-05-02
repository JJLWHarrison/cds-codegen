/*
 * Consumer Data Standards
 * API sets created by the Australian Consumer Data Standards to meet the needs of the Consumer Data Right
 *
 */


package au.org.consumerdatastandards.client.api;

import com.google.gson.reflect.TypeToken;


import org.threeten.bp.OffsetDateTime;

import au.org.consumerdatastandards.client.ApiCallback;
import au.org.consumerdatastandards.client.ApiClient;
import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.Configuration;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.model.ResponseBankingProductById;
import au.org.consumerdatastandards.client.model.ResponseBankingProductList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingProductsApi {
    private ApiClient localVarApiClient;

    public BankingProductsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BankingProductsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getProductDetail
     * @param productId ID of the specific product requested (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call getProductDetailCall(String productId, final ApiCallback<ResponseBankingProductById> _callback) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/banking/products/{productId}"
            .replaceAll("\\{" + "productId" + "\\}", localVarApiClient.escapeString(productId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    private okhttp3.Call getProductDetailValidateBeforeCall(String productId, final ApiCallback<ResponseBankingProductById> _callback) throws ApiException {
        
        // verify the required parameter 'productId' is set
        if (productId == null) {
            throw new ApiException("Missing the required parameter 'productId' when calling getProductDetail(Async)");
        }
        

        okhttp3.Call localVarCall = getProductDetailCall(productId, _callback);
        return localVarCall;

    }

    /**
     * Get Product Detail
     * Obtain detailed information on a single product offered openly to the market
     * @param productId ID of the specific product requested (required)
     * @return ResponseBankingProductById
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseBankingProductById getProductDetail(String productId) throws ApiException {
        ApiResponse<ResponseBankingProductById> localVarResp = getProductDetailWithHttpInfo(productId);
        return localVarResp.getData();
    }

    /**
     * Get Product Detail
     * Obtain detailed information on a single product offered openly to the market
     * @param productId ID of the specific product requested (required)
     * @return ApiResponse&lt;ResponseBankingProductById&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseBankingProductById> getProductDetailWithHttpInfo(String productId) throws ApiException {
        okhttp3.Call localVarCall = getProductDetailValidateBeforeCall(productId, null);
        Type localVarReturnType = new TypeToken<ResponseBankingProductById>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get Product Detail (asynchronously)
     * Obtain detailed information on a single product offered openly to the market
     * @param productId ID of the specific product requested (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call getProductDetailAsync(String productId, final ApiCallback<ResponseBankingProductById> _callback) throws ApiException {

        okhttp3.Call localVarCall = getProductDetailValidateBeforeCall(productId, _callback);
        Type localVarReturnType = new TypeToken<ResponseBankingProductById>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listProducts
     * @param effective Allows for the filtering of products based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &amp;#39;CURRENT&amp;#39; (optional, default to CURRENT)
     * @param updatedSince Only include products that have been updated after the specified date and time. If absent defaults to include all products (optional)
     * @param brand Filter results based on a specific brand (optional)
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call listProductsCall(String effective, OffsetDateTime updatedSince, String brand, String productCategory, Integer page, Integer pageSize, final ApiCallback<ResponseBankingProductList> _callback) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/banking/products";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (effective != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effective", effective));
        }

        if (updatedSince != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("updated-since", updatedSince));
        }

        if (brand != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("brand", brand));
        }

        if (productCategory != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("product-category", productCategory));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (pageSize != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page-size", pageSize));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _callback);
    }

    private okhttp3.Call listProductsValidateBeforeCall(String effective, OffsetDateTime updatedSince, String brand, String productCategory, Integer page, Integer pageSize, final ApiCallback<ResponseBankingProductList> _callback) throws ApiException {
        okhttp3.Call localVarCall = listProductsCall(effective, updatedSince, brand, productCategory, page, pageSize, _callback);
        return localVarCall;

    }

    /**
     * Get Products
     * Obtain a list of products that are currently openly offered to the market  Note that the results returned by this end point are expected to be ordered according to updated-since  ### Conventions In the product reference payloads there are a number of recurring conventions that are explained here, in one place.  #### Arrays Of Features  In the product detail payload there are a number of arrays articulating generic features, constraints, prices, etc. The intent of these arrays is as follows:  - Each element in an array has the same structure so that clients can reliably interpret the payloads - Each element as a type element that is an enumeration of the specific aspect of a product being described, such as types of fees. - Each element has a field name additionalValue. This is a generic field with contents that will vary based on the type of object being described. The contents of this field for the ADDITIONAL_CARDS feature is the number of cards allowed while the contents of this field for the MAX_LIMIT constraint would be the maximum credit limit allowed for the product. - An element in these arrays of the same type may appear more than once. For instance, a product may offer two separate loyalty programs that the customer can select from. A fixed term mortgage may have different rates for different term lengths. - An element in these arrays may contain an additionalInfo and additionalInfoUri field. The additionalInfo field is used to provide displayable text clarifying the purpose of the element in some way when the product is presented to a customer. The additionalInfoUri provides a link to externally hosted information specifically relevant to that feature of the product. - Depending on the type of data being represented there may be additional specific fields.  #### URIs To More Information  As the complexities and nuances of a financial product can not easily be fully expressed in a data structure without a high degree of complexity it is necessary to provide additional reference information that a potential customer can access so that they are fully informed of the features and implications of the product. The payloads for product reference therefore contain numerous fields that are provided to allow the product provider to describe the product more fully using a web page hosted on their on channels.  These URIs do not need to all link to different pages. If desired, they can all link to a single hosted page and use difference HTML anchors to focus on a specific topic such as eligibility or fees.  #### Linkage To Accounts From the moment that a customer applies for a product and an account is created the account and the product that spawned it will diverge.  Rates and features of the product may change and a discount may be negotiated for the account.  For this reason, while productCategory is a common field between accounts and products, there is no specific ID that can be used to link an account to a product within the regime.  Similarly, many of the fields and objects in the product payload will appear in the account detail payload but the structures and semantics are not identical as one refers to a product that can potentially be originated and one refers to an account that actual has been instantiated and created along with the associated decisions inherent in that process.  #### Dates It is expected that data consumers needing this data will call relatively frequently to ensure the data they have is representative of the current offering from a bank.  To minimise the volume and frequency of these calls the ability to set a lastUpdated field with the date and time of the last update to this product is included.  A call for a list of products can then be filtered to only return products that have been updated since the last time that data was obtained using the updated-since query parameter.  In addition, the concept of effective date and time has also been included.  This allows for a product to be marked for obsolescence, or introduction, from a certain time without the need for an update to show that a product has been changed.  The inclusion of these dates also removes the need to represent deleted products in the payload.  Products that are no long offered can be marked not effective for a few weeks before they are then removed from the product set as an option entirely.
     * @param effective Allows for the filtering of products based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &amp;#39;CURRENT&amp;#39; (optional, default to CURRENT)
     * @param updatedSince Only include products that have been updated after the specified date and time. If absent defaults to include all products (optional)
     * @param brand Filter results based on a specific brand (optional)
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ResponseBankingProductList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseBankingProductList listProducts(String effective, OffsetDateTime updatedSince, String brand, String productCategory, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingProductList> localVarResp = listProductsWithHttpInfo(effective, updatedSince, brand, productCategory, page, pageSize);
        return localVarResp.getData();
    }

    /**
     * Get Products
     * Obtain a list of products that are currently openly offered to the market  Note that the results returned by this end point are expected to be ordered according to updated-since  ### Conventions In the product reference payloads there are a number of recurring conventions that are explained here, in one place.  #### Arrays Of Features  In the product detail payload there are a number of arrays articulating generic features, constraints, prices, etc. The intent of these arrays is as follows:  - Each element in an array has the same structure so that clients can reliably interpret the payloads - Each element as a type element that is an enumeration of the specific aspect of a product being described, such as types of fees. - Each element has a field name additionalValue. This is a generic field with contents that will vary based on the type of object being described. The contents of this field for the ADDITIONAL_CARDS feature is the number of cards allowed while the contents of this field for the MAX_LIMIT constraint would be the maximum credit limit allowed for the product. - An element in these arrays of the same type may appear more than once. For instance, a product may offer two separate loyalty programs that the customer can select from. A fixed term mortgage may have different rates for different term lengths. - An element in these arrays may contain an additionalInfo and additionalInfoUri field. The additionalInfo field is used to provide displayable text clarifying the purpose of the element in some way when the product is presented to a customer. The additionalInfoUri provides a link to externally hosted information specifically relevant to that feature of the product. - Depending on the type of data being represented there may be additional specific fields.  #### URIs To More Information  As the complexities and nuances of a financial product can not easily be fully expressed in a data structure without a high degree of complexity it is necessary to provide additional reference information that a potential customer can access so that they are fully informed of the features and implications of the product. The payloads for product reference therefore contain numerous fields that are provided to allow the product provider to describe the product more fully using a web page hosted on their on channels.  These URIs do not need to all link to different pages. If desired, they can all link to a single hosted page and use difference HTML anchors to focus on a specific topic such as eligibility or fees.  #### Linkage To Accounts From the moment that a customer applies for a product and an account is created the account and the product that spawned it will diverge.  Rates and features of the product may change and a discount may be negotiated for the account.  For this reason, while productCategory is a common field between accounts and products, there is no specific ID that can be used to link an account to a product within the regime.  Similarly, many of the fields and objects in the product payload will appear in the account detail payload but the structures and semantics are not identical as one refers to a product that can potentially be originated and one refers to an account that actual has been instantiated and created along with the associated decisions inherent in that process.  #### Dates It is expected that data consumers needing this data will call relatively frequently to ensure the data they have is representative of the current offering from a bank.  To minimise the volume and frequency of these calls the ability to set a lastUpdated field with the date and time of the last update to this product is included.  A call for a list of products can then be filtered to only return products that have been updated since the last time that data was obtained using the updated-since query parameter.  In addition, the concept of effective date and time has also been included.  This allows for a product to be marked for obsolescence, or introduction, from a certain time without the need for an update to show that a product has been changed.  The inclusion of these dates also removes the need to represent deleted products in the payload.  Products that are no long offered can be marked not effective for a few weeks before they are then removed from the product set as an option entirely.
     * @param effective Allows for the filtering of products based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &amp;#39;CURRENT&amp;#39; (optional, default to CURRENT)
     * @param updatedSince Only include products that have been updated after the specified date and time. If absent defaults to include all products (optional)
     * @param brand Filter results based on a specific brand (optional)
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ApiResponse&lt;ResponseBankingProductList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseBankingProductList> listProductsWithHttpInfo(String effective, OffsetDateTime updatedSince, String brand, String productCategory, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call localVarCall = listProductsValidateBeforeCall(effective, updatedSince, brand, productCategory, page, pageSize, null);
        Type localVarReturnType = new TypeToken<ResponseBankingProductList>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get Products (asynchronously)
     * Obtain a list of products that are currently openly offered to the market  Note that the results returned by this end point are expected to be ordered according to updated-since  ### Conventions In the product reference payloads there are a number of recurring conventions that are explained here, in one place.  #### Arrays Of Features  In the product detail payload there are a number of arrays articulating generic features, constraints, prices, etc. The intent of these arrays is as follows:  - Each element in an array has the same structure so that clients can reliably interpret the payloads - Each element as a type element that is an enumeration of the specific aspect of a product being described, such as types of fees. - Each element has a field name additionalValue. This is a generic field with contents that will vary based on the type of object being described. The contents of this field for the ADDITIONAL_CARDS feature is the number of cards allowed while the contents of this field for the MAX_LIMIT constraint would be the maximum credit limit allowed for the product. - An element in these arrays of the same type may appear more than once. For instance, a product may offer two separate loyalty programs that the customer can select from. A fixed term mortgage may have different rates for different term lengths. - An element in these arrays may contain an additionalInfo and additionalInfoUri field. The additionalInfo field is used to provide displayable text clarifying the purpose of the element in some way when the product is presented to a customer. The additionalInfoUri provides a link to externally hosted information specifically relevant to that feature of the product. - Depending on the type of data being represented there may be additional specific fields.  #### URIs To More Information  As the complexities and nuances of a financial product can not easily be fully expressed in a data structure without a high degree of complexity it is necessary to provide additional reference information that a potential customer can access so that they are fully informed of the features and implications of the product. The payloads for product reference therefore contain numerous fields that are provided to allow the product provider to describe the product more fully using a web page hosted on their on channels.  These URIs do not need to all link to different pages. If desired, they can all link to a single hosted page and use difference HTML anchors to focus on a specific topic such as eligibility or fees.  #### Linkage To Accounts From the moment that a customer applies for a product and an account is created the account and the product that spawned it will diverge.  Rates and features of the product may change and a discount may be negotiated for the account.  For this reason, while productCategory is a common field between accounts and products, there is no specific ID that can be used to link an account to a product within the regime.  Similarly, many of the fields and objects in the product payload will appear in the account detail payload but the structures and semantics are not identical as one refers to a product that can potentially be originated and one refers to an account that actual has been instantiated and created along with the associated decisions inherent in that process.  #### Dates It is expected that data consumers needing this data will call relatively frequently to ensure the data they have is representative of the current offering from a bank.  To minimise the volume and frequency of these calls the ability to set a lastUpdated field with the date and time of the last update to this product is included.  A call for a list of products can then be filtered to only return products that have been updated since the last time that data was obtained using the updated-since query parameter.  In addition, the concept of effective date and time has also been included.  This allows for a product to be marked for obsolescence, or introduction, from a certain time without the need for an update to show that a product has been changed.  The inclusion of these dates also removes the need to represent deleted products in the payload.  Products that are no long offered can be marked not effective for a few weeks before they are then removed from the product set as an option entirely.
     * @param effective Allows for the filtering of products based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &amp;#39;CURRENT&amp;#39; (optional, default to CURRENT)
     * @param updatedSince Only include products that have been updated after the specified date and time. If absent defaults to include all products (optional)
     * @param brand Filter results based on a specific brand (optional)
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call listProductsAsync(String effective, OffsetDateTime updatedSince, String brand, String productCategory, Integer page, Integer pageSize, final ApiCallback<ResponseBankingProductList> _callback) throws ApiException {

        okhttp3.Call localVarCall = listProductsValidateBeforeCall(effective, updatedSince, brand, productCategory, page, pageSize, _callback);
        Type localVarReturnType = new TypeToken<ResponseBankingProductList>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
