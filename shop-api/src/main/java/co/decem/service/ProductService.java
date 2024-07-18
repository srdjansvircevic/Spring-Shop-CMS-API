package co.decem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.decem.model.Product;

public interface ProductService {
    
    Product getProductById(Long id);

    Product createProduct(Product product);

    Page<Product> getAllProducts(Pageable pageable);
}
