package co.decem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import co.decem.model.Product;
import co.decem.service.ProductService;
import co.decem.service.RelatedProductsService;

@RestController
@RequestMapping("/api/products/related")
public class RelatedProductsController {

    @Autowired
    private RelatedProductsService relatedProductService;
        
    @Autowired
    private ProductService productService;

    @PostMapping("/{id}")
    public void createRelatedProduct(@RequestBody List<Long> relatedProductIds, @PathVariable Long productId) {
        if (!productService.existsById(productId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product ID " + productId + " does not exist.");
        }

        if (!productService.existsAllByIdIn(relatedProductIds)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product IDs " + relatedProductIds + " does not exist.");
        }

        relatedProductService.createRelatedProduct(relatedProductIds, productId);
    }

    @GetMapping("/{id}")
    public List<Product> getRelatedProducts(@PathVariable Long id) {
        return relatedProductService.getRelatedProducts(id);
    }
    
}
