package com.gescom.gescom.services;

import com.gescom.gescom.entities.Category;
import com.gescom.gescom.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repository;

    CategoryServiceImpl(final CategoryRepository repository) {
        this.repository = repository ;
    }
    @Override
    public void createCategory(Category category) {
        this.repository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }


    @Override
    public void editCategory(Category category, long id) {
      Category c =  this.repository.getReferenceById(id);
      c.setDesignation(category.getDesignation());
      this.repository.save(c);
    }

    @Override
    public Category findOne(long id) {
        return this.repository.getReferenceById(id);
    }
}
