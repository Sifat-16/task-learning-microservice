package com.task.task.service.category;

import com.task.task.model.category.Category;
import com.task.task.request.category.CreateCategoryRequest;
import com.task.task.request.category.UpdateCategoryRequest;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(UUID id);
    Category createCategory(CreateCategoryRequest createCategoryRequest);
    Category updateCategory(UUID id, UpdateCategoryRequest updateCategoryRequest);
    Boolean deleteCategory(UUID id);
}
