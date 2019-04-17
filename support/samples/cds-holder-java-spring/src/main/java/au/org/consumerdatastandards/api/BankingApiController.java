package au.org.consumerdatastandards.api;

import au.org.consumerdatastandards.model.ResponseBankingProductById;
import au.org.consumerdatastandards.model.ResponseBankingProductList;
import au.org.consumerdatastandards.repository.BankingProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingApiController implements BankingApi {

    @Autowired
    private BankingProductsRepository repository;

    private final NativeWebRequest request;

    @Autowired
    public BankingApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<ResponseBankingProductById> getProductDetail(String productId) {
        return null;
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
        return null;
    }
}
