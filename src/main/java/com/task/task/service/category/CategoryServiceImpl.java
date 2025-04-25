package com.task.task.service.category;

import com.task.task.component.WebclientComponent;
import com.task.task.response.category.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final WebclientComponent webclientComponent;

    @Override
    public CategoryResponse getCategoryById(UUID id) {
        return webclientComponent.webClientBuilder()
                .baseUrl("http://localhost:8081")
                .build()
                .get()
                .uri("/get-category-by-id/"+id)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> (CategoryResponse) response.get("data"))
                .block();
    }
}
