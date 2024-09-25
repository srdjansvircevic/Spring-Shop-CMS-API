package co.decem.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import co.decem.dao.CategoryRepository;
import co.decem.dao.FeaturedProductRepository;
import co.decem.model.Category;
import co.decem.model.FeaturedProduct;
import co.decem.model.dto.HomepageDTO;
import co.decem.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

    @Value("${homepage.cache.key}")
    private String homepageCacheKey;

    @Autowired
    private FeaturedProductRepository featuredProductRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public HomepageDTO getHomePageData() {
        boolean isCached = Boolean.TRUE.equals(redisTemplate.hasKey(homepageCacheKey));

        if (isCached) {
            return (HomepageDTO) redisTemplate.opsForValue().get(homepageCacheKey);
        }

        return getHomepageDTOFromDB();
    }

    private HomepageDTO getHomepageDTOFromDB() {
        List<FeaturedProduct> featuredProducts = featuredProductRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        return new HomepageDTO(featuredProducts, categories);
    }

    @Scheduled(fixedRate = 10000)
    public void refreshHomePageData() {
        System.out.println("Refreshing homepage data and storing in Redis...");
        HomepageDTO home = getHomepageDTOFromDB();
        redisTemplate.opsForValue().set(homepageCacheKey, home);
    }
}
