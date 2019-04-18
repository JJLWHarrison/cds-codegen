package au.org.consumerdatastandards.repository;

import au.org.consumerdatastandards.model.BankingProductDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductDetailsRepository extends CrudRepository<BankingProductDetail, String> {
}
