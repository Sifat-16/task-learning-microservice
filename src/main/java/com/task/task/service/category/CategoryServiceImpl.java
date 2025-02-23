package com.task.task.service.category;

import com.task.task.model.category.Category;
import com.task.task.repository.category.CategoryRepository;
import com.task.task.request.category.CreateCategoryRequest;
import com.task.task.request.category.UpdateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
    }

    @Override
    public Category createCategory(CreateCategoryRequest createCategoryRequest) {
        return categoryRepository.save(createCategoryRequest.toCategory());
    }

    @Override
    public Category updateCategory(UUID id, UpdateCategoryRequest updateCategoryRequest) {
        Category category = getCategoryById(id);

        if(updateCategoryRequest.getName() != null){
            category.setName(updateCategoryRequest.getName());
        }

        if(updateCategoryRequest.getDescription() != null){
            category.setDescription(updateCategoryRequest.getDescription());
        }

        return categoryRepository.save(category);
    }

    @Override
    public Boolean deleteCategory(UUID id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        }catch (Exception e){
            throw new RuntimeException("Delete failed");
        }
    }
}
