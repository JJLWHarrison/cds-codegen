package au.org.consumerdatastandards.holder.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import au.org.consumerdatastandards.holder.DB;
import au.org.consumerdatastandards.holder.api.*;
import au.org.consumerdatastandards.models.BankingProduct;
import au.org.consumerdatastandards.models.Links;
import au.org.consumerdatastandards.models.LinksPaginated;
import au.org.consumerdatastandards.models.MetaPaginated;
import au.org.consumerdatastandards.models.ResponseBankingProductById;
import au.org.consumerdatastandards.models.ResponseBankingProductList;
import au.org.consumerdatastandards.models.ResponseBankingProductListData;

public class ProductApiServiceImpl implements ProductsApi {

    @Override
    public ResponseBankingProductById getProductDetail(String productId, SecurityContext securityContext) {
        // do some magic!
        return new ResponseBankingProductById();
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
         * Wirte response
         */
        myResponse.setMeta(myMeta);
        myResponse.setLinks(myLinks);
        myResponse.setData(productListData);
        session.getTransaction().commit();
        session.close();

        return myResponse;
    }
}
