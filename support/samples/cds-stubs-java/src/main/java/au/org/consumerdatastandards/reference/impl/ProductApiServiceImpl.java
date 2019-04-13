package au.org.consumerdatastandards.reference.impl;

import java.util.Date;

import javax.ws.rs.core.SecurityContext;

import au.org.consumerdatastandards.reference.api.*;
import au.org.consumerdatastandards.reference.models.ResponseBankingProductById;
import au.org.consumerdatastandards.reference.models.ResponseBankingProductList;

public class ProductApiServiceImpl implements ProductsApi {
      @Override
    public ResponseBankingProductById getProductDetail(String productId,SecurityContext securityContext) {
      // do some magic!
      return new ResponseBankingProductById();
  }
      @Override
    public ResponseBankingProductList listProducts(String effective,Date updatedSince,String brand,String productCategory,Integer page,Integer pageSize,SecurityContext securityContext) {
      // do some magic!
      return new ResponseBankingProductList();
  }
}
