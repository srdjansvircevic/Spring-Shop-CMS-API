package co.decem.service;

import co.decem.model.Product;

import java.util.List;

public interface RelatedProductsService {
    
        void createRelatedProduct(List<Long> relatedProductIds, Long productId);

        List<Product> getRelatedProducts(Long id);
}
