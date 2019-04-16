package au.org.consumerdatastandards.holder.impl;

import au.org.consumerdatastandards.holder.DB;
import au.org.consumerdatastandards.holder.api.ProductsApi;
import au.org.consumerdatastandards.models.*;
import org.hibernate.Session;

import javax.ws.rs.core.SecurityContext;
import java.util.Date;
import java.util.List;

public class ProductApiServiceImpl implements ProductsApi {

    @Override
    public ResponseBankingProductById getProductDetail(String productId, SecurityContext securityContext) {
        ResponseBankingProductById myResponse = new ResponseBankingProductById();
        
        Session session = DB.getSessionFactory().openSession();
        session.beginTransaction();
        
        BankingProduct thisProduct = session.get(BankingProduct.class, productId);

        session.close();
        
        /**
         * Links/Meta objects
         */
        Links myLinks = new Links();
        myLinks.setSelf(String.format("/banking/product/%s", productId));
        Meta myMeta = new Meta();
        
        myResponse.setLinks(myLinks);
//        myResponse.setMeta(myMeta);
        myResponse.setData(new BankingProductDetail(thisProduct));
        
        return myResponse;
    }

    @Override
    public ResponseBankingProductList listProducts(String effective, Date updatedSince, String brand,
            String productCategory, Integer page, Integer pageSize, SecurityContext securityContext) {

        ResponseBankingProductList myResponse = new ResponseBankingProductList();
        
        Session session = DB.getSessionFactory().openSession();
        session.beginTransaction();
        List<?> result = session.createQuery("from BankingProduct").list();
        
        /**
         * Links/Meta objects
         */
        LinksPaginated myLinks = new LinksPaginated();
        MetaPaginated myMeta = new MetaPaginated();
        
        /**
         * Links content
         */
        int totalPages = (int)(Math.ceil((result.size() / pageSize)));
        myLinks.setFirst(String.format("/banking/products?page=%s&page-size=%s", 1, pageSize));
        if(totalPages > 1) { myLinks.setLast(String.format("/banking/products?page=%s&page-size=%s", totalPages, pageSize)); }
        if(page > 1) {  myLinks.setPrev(String.format("/banking/products?page=%s&page-size=%s", page-1, pageSize)); }
        if(page < totalPages) {  myLinks.setNext(String.format("/banking/products?page=%s&page-size=%s", page+1, pageSize)); }
        myLinks.setSelf(String.format("/banking/products?page=%s&page-size=%s", page, pageSize));
        
        /**
         * Meta content
         */
        myMeta.setTotalRecords(result != null ? result.size() : 0);
        myMeta.setTotalPages(totalPages);
        
        /**
         * Wire product list data
         */
        ResponseBankingProductListData productListData = new ResponseBankingProductListData();
        productListData.setProducts((List<BankingProduct>) result);

        
        /**
         * Write response
         */
        myResponse.setMeta(myMeta);
        myResponse.setLinks(myLinks);
        myResponse.setData(productListData);
        session.getTransaction().commit();
        session.close();

        return myResponse;
    }
}
