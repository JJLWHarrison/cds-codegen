package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingProduct;
import au.org.consumerdatastandards.holder.model.BankingProductDetail;
import au.org.consumerdatastandards.holder.repository.BankingProductDetailsRepository;
import au.org.consumerdatastandards.holder.repository.BankingProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankingProductsService {

    private final BankingProductsRepository productsRepository;

    private final BankingProductDetailsRepository productDetailsRepository;

    @Autowired
    public BankingProductsService(BankingProductsRepository productsRepository, BankingProductDetailsRepository productDetailsRepository) {
        this.productsRepository = productsRepository;
        this.productDetailsRepository = productDetailsRepository;
    }

    public Page<BankingProduct> findProductsLike(String effective, BankingProduct example, Pageable pageable) {
        return productsRepository.findAll((Specification<BankingProduct>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if("CURRENT".equals(effective) || effective == null) {
                // If Effective is not supplied, assume CURRENT as per Standard
                // https://consumerdatastandardsaustralia.github.io/standards/#get-products
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("effectiveFrom"), now)));
                predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("effectiveTo"), now)));
            } else if("FUTURE".equals(effective)) {
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("effectiveFrom"), now)));
            }
            if (example.getProductCategory() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("productCategory"), example.getProductCategory())));
            }
            if (example.getLastUpdated() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("lastUpdated"), example.getLastUpdated())));
            }
            if (!StringUtils.isEmpty(example.getBrand())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("brand"), "%" + example.getBrand() + "%")));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public BankingProductDetail getProductDetail(String productId) {

        Optional<BankingProductDetail> byId = productDetailsRepository.findById(productId);
        return byId.orElse(null);
    }
}
