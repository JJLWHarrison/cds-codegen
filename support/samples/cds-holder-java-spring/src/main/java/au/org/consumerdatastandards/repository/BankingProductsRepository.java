package au.org.consumerdatastandards.repository;

import au.org.consumerdatastandards.model.BankingProduct;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankingProductsRepository
    extends PagingAndSortingRepository<BankingProduct, String>, JpaSpecificationExecutor<BankingProduct> {

}
