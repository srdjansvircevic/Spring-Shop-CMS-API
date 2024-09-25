package co.decem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.decem.model.Product;
import co.decem.service.ProductService;

@RestController
@RequestMapping("/api/pages/single-product-page")
@CrossOrigin()
public class SingleProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductByIdWithRelatedProducts(@PathVariable Long id) {
        return productService.getProductByIdWithRelatedProducts(id);
    }
    
}
