package co.decem.service;

import java.util.List;

import co.decem.model.Category;

public interface CategoryService {

    List<Category> getAll();
    Category getCategoryById(Long id);
    
}
