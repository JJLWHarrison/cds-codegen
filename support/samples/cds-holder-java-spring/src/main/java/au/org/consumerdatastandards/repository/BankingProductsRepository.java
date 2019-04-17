package au.org.consumerdatastandards.repository;

import au.org.consumerdatastandards.model.BankingProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductsRepository extends CrudRepository<BankingProduct, String> {
}
