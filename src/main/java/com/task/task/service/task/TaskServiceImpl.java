package com.task.task.service.task;
import com.task.task.component.WebclientComponent;
import com.task.task.exception.TaskNotFoundException;
import com.task.task.model.task.Task;
import com.task.task.repository.task.TaskRepository;
import com.task.task.request.task.CreateTaskRequest;
import com.task.task.request.task.UpdateTaskRequest;
import com.task.task.response.category.CategoryResponse;
import com.task.task.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final CategoryService categoryService;

    @Override
    public List<Task> getAllTasks() {
        List<Task> allTasks = taskRepository.findAll();

//        allTasks.stream().map(task -> {
//           task.setCategories(categoryService.getCategoryById(task));
//        });

        return allTasks;
    }

    @Override
    public Task getTaskById(UUID id) {
        return taskRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("Task not found"));
    }

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        return taskRepository.save(createTaskRequest.toTask());
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest updateTaskRequest) {
        Task task = getTaskById(id);

        if(updateTaskRequest.getTitle() != null){
            task.setTitle(updateTaskRequest.getTitle());
        }

        if(updateTaskRequest.getDescription() != null){
            task.setDescription(updateTaskRequest.getDescription());
        }

//        if(updateTaskRequest.getCategories() != null){
//            task.setCategories(updateTaskRequest.getCategories());
//        }

        return taskRepository.save(task);

    }

    @Override
    public Boolean deleteTask(UUID id) {
        try {
            taskRepository.deleteById(id);
            return true;
        }catch (Exception e){
            throw new RuntimeException("Delete failed");
        }
    }



}
