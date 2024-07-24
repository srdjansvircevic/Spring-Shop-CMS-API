package co.decem.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import co.decem.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);
    Boolean existsAllByIdIn(List<Long> ids);

    @Query("SELECT p.id FROM Product p WHERE p.id IN :ids")
    List<Long> findExistingIds(@Param("ids") List<Long> ids);

    @Query("SELECT COUNT(p.id) FROM Product p WHERE p.id IN :ids")
    long countByIds(@Param("ids") List<Long> ids);
    
    
}