package co.decem.model.dto;

import java.util.List;

import co.decem.model.Category;
import co.decem.model.FeaturedProduct;

public class HomepageDTO {

    private List<FeaturedProduct> featuredProducts;
    private List<Category> categories;

    public HomepageDTO(List<FeaturedProduct> featuredProducts, List<Category> categories) {
        this.featuredProducts = featuredProducts;
        this.categories = categories;
    }
    
    public List<FeaturedProduct> getFeaturedProducts() {
        return featuredProducts;
    }
    public void setFeaturedProducts(List<FeaturedProduct> featuredProducts) {
        this.featuredProducts = featuredProducts;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    
}
