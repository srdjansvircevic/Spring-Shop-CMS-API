package co.decem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.decem.dao.CategoryRepository;
import co.decem.dao.FeaturedProductRepository;
import co.decem.model.Category;
import co.decem.model.FeaturedProduct;
import co.decem.model.HomepageDTO;
import co.decem.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

    @Autowired
    private FeaturedProductRepository featuredProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public HomepageDTO getHomePageData() {
        
        List<FeaturedProduct> featuredProducts = featuredProductRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        HomepageDTO home = new HomepageDTO(featuredProducts, categories);
        return home;
    }
    
}
