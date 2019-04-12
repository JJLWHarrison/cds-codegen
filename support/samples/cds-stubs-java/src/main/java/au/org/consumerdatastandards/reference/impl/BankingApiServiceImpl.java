package au.org.consumerdatastandards.reference.impl;

import java.util.Date;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import au.org.consumerdatastandards.reference.api.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyEapServerCodegen", date = "2019-04-12T13:43:52.817+10:00")
public class BankingApiServiceImpl implements BankingApi {
      @Override
    public Response getProductDetail(String productId,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
      @Override
    public Response listProducts(String effective,Date updatedSince,String brand,String productCategory,Integer page,Integer pageSize,SecurityContext securityContext) {
      // do some magic!
      return Response.ok().build();
  }
}
