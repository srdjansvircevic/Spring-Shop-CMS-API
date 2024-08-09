package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.Product;
import co.decem.model.RelatedProduct;

public interface RelatedProductRepository extends JpaRepository<RelatedProduct, Long>{

    RelatedProduct findByProductId(Product product);
    
}
