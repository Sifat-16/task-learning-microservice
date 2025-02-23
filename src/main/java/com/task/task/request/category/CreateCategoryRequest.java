package com.task.task.request.category;

import com.task.task.model.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCategoryRequest {
    private String categoryName;
    private String description;

    public Category toCategory() {
        return Category.builder()
                .name(categoryName)
                .description(description)
                .build();
    }
}
