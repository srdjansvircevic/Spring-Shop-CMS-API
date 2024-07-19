package co.decem.model;

import java.util.List;

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
