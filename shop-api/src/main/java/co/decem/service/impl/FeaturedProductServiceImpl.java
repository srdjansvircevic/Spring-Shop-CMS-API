package co.decem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.decem.dao.FeaturedProductRepository;
import co.decem.model.FeaturedProduct;
import co.decem.service.FeaturedProductService;

@Service
public class FeaturedProductServiceImpl implements FeaturedProductService{

    @Autowired
    private FeaturedProductRepository featuredProductRepository;

    @Override
    public List<FeaturedProduct> getAll() {
        return featuredProductRepository.findAll();
    }

}
