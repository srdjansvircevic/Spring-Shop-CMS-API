package co.decem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.decem.model.Filter;

public interface FilterRepository extends JpaRepository<Filter, Long> {
    
}
