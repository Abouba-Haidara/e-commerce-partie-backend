package com.gescom.gescom.services;

import com.gescom.gescom.entities.Category;

import java.util.List;

public interface CategoryService {
    void createCategory(Category category);
    List<Category> findAll();
    void delete(long id);
    void editCategory(Category category, long id);
}
