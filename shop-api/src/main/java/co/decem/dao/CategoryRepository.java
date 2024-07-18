package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
