package com.task.task.controller.category;

import com.task.task.request.category.CreateCategoryRequest;
import com.task.task.request.category.UpdateCategoryRequest;
import com.task.task.response.ApiResponse;
import com.task.task.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse> fetchAllCategory() {
        try {
            return ResponseEntity.ok(new ApiResponse("All Categories", categoryService.getAllCategories()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No category available", e.getMessage()));
        }
    }

    @PostMapping(value = "/create-category")
    public ResponseEntity<ApiResponse> createCategory(@ModelAttribute CreateCategoryRequest createCategoryRequest) {
        try {
            return ResponseEntity.ok(new ApiResponse("Category Created Successfully", categoryService.createCategory(createCategoryRequest)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Failed to create category", e.getMessage()));
        }
    }

    @GetMapping(value = "/get-category-by-id/{id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ApiResponse("Category Found", categoryService.getCategoryById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Category not Found", e.getMessage()));
        }
    }

    @PutMapping(value = "/update-category/{id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable UUID id, @ModelAttribute UpdateCategoryRequest updateCategoryRequest) {
        try {
            return ResponseEntity.ok(new ApiResponse("Category Updated Successfully", categoryService.updateCategory(id, updateCategoryRequest)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Something went wrong!", e.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete-category/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable UUID id){
        try{
            return ResponseEntity.ok(new ApiResponse("Category Deleted Successfully", categoryService.deleteCategory(id)));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Something went wrong!", e.getMessage()));
        }
    }
}
