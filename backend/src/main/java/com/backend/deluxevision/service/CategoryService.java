package com.backend.deluxevision.service;

import com.backend.deluxevision.model.Category;
import com.backend.deluxevision.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

}
