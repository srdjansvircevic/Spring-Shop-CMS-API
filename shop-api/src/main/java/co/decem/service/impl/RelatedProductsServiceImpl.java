package co.decem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.decem.dao.ProductRepository;
import co.decem.dao.RelatedProductRepository;
import co.decem.model.RelatedProduct;
import co.decem.model.Product;
import co.decem.service.RelatedProductsService;

@Service
public class RelatedProductsServiceImpl implements RelatedProductsService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RelatedProductRepository relatedProductRepository;

    @Override
    public void createRelatedProduct(List<Long> relatedProductIds, Long productId) {

        RelatedProduct relatedProduct = new RelatedProduct();
        Product product = new Product();
        product.setId(productId);
        relatedProduct.setProductId(product);
        List<Product> products = new ArrayList<>();
        for (Long prodId : relatedProductIds){
            Product relatedProducts = productRepository.findById(prodId).orElse(null);
            products.add(relatedProducts);
        }
        relatedProduct.setRelatedProducts(products);
        relatedProductRepository.save(relatedProduct);

    }

    @Override
    public List<Product> getRelatedProducts(Long id) {

        Product product = productRepository.findById(id).orElse(null);
        RelatedProduct relatedProduct = relatedProductRepository.findByProductId(product);

        return relatedProduct.getRelatedProducts();

    }
    
}
