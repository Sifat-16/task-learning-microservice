package com.task.task.request.task;

import com.task.task.model.category.Category;
import com.task.task.model.task.Task;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskRequest {
    private String title;
    private String description;
    private List<Category> categories;


    public Task toTask(){
        return Task.builder()
                .title(title)
                .description(description)
                .categories(categories)
                .build();
    }
}
