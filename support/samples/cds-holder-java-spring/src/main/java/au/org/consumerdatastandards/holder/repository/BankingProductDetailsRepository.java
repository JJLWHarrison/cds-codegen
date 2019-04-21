package au.org.consumerdatastandards.holder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import au.org.consumerdatastandards.holder.model.BankingProductDetail;

@Repository
public interface BankingProductDetailsRepository extends CrudRepository<BankingProductDetail, String> {
}
