package co.decem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import co.decem.model.Product;

public interface ProductService {
    
    Product getProductById(Long id);

    Product createProduct(Product product);

    Page<Product> getAllProducts(Pageable pageable);

    Product getProductByIdWithRelatedProducts(Long id);

    boolean existsById(Long id);

    boolean existsAllByIdIn(List<Long> ids);
}
