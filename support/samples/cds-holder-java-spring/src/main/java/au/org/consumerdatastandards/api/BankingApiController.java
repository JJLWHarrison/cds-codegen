package au.org.consumerdatastandards.api;

import au.org.consumerdatastandards.model.*;
import au.org.consumerdatastandards.service.BankingProductsService;
import au.org.consumerdatastandards.util.WebLinkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingApiController implements BankingApi {

    private final BankingProductsService service;

    private final NativeWebRequest request;

    @Autowired
    public BankingApiController(NativeWebRequest request, BankingProductsService service) {
        this.request = request;
        this.service = service;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<ResponseBankingProductById> getProductDetail(String productId) {
        return new ResponseEntity<>(new ResponseBankingProductById()
            .data(service.getProductDetail(productId))
            .links(new Links()
                .self(WebLinkUtil.getOriginalUrl(request))), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingProductList> listProducts(
        @Valid String effective,
        @Valid OffsetDateTime updatedSince,
        @Valid String brand,
        @Valid String productCategory,
        @Valid Integer page,
        @Valid Integer pageSize)
    {
        BankingProduct example = new BankingProduct()
            .lastUpdated(updatedSince)
            .brand(brand);

        if (!StringUtils.isEmpty(productCategory)) {
            try {
                example.productCategory(BankingEnumProductCategory.fromValue(productCategory));
            } catch (IllegalArgumentException e) {
                // ignored
            }
        }

        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingProduct> productsPage = service.findProductsLike(effective, example, PageRequest.of(actualPage, actualPageSize));

        String self = WebLinkUtil.getPaginatedLink(request, actualPage, actualPageSize);
        return new ResponseEntity<>(new ResponseBankingProductList()
            .data(new ResponseBankingProductListData().products(productsPage.getContent()))
            .links(new LinksPaginated().first(WebLinkUtil.getPaginatedLink(request,1, actualPageSize))
                .self(self)
                .prev(productsPage.isFirst() || productsPage.getTotalPages() == 0 ? self : WebLinkUtil.getPaginatedLink(request, actualPage - 1, actualPageSize))
                .next(productsPage.isLast() || productsPage.getTotalPages() == 0 ? self : WebLinkUtil.getPaginatedLink(request, actualPage + 1, actualPageSize))
                .last(productsPage.getTotalPages() == 0? self: WebLinkUtil.getPaginatedLink(request, productsPage.getTotalPages(), actualPageSize)))
            .meta(new MetaPaginated().totalPages(productsPage.getTotalPages()).totalRecords((int)productsPage.getTotalElements())),
            HttpStatus.OK);
    }

    private Integer getPagingValue(@Valid Integer page, int defaultValue) {
        return page != null && page > 0 ? page : defaultValue;
    }
}
