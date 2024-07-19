package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.FeaturedProduct;

public interface FeaturedProductRepository extends JpaRepository<FeaturedProduct, Long>{
    
} 