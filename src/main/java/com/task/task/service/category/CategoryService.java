package com.task.task.service.category;

import com.task.task.response.category.CategoryResponse;

import java.util.UUID;

public interface CategoryService {
    CategoryResponse getCategoryById(UUID id);
}
