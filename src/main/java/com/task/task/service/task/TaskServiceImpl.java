package com.task.task.service.task;

import com.task.task.model.task.Task;
import com.task.task.repository.task.TaskRepository;
import com.task.task.request.task.CreateTaskRequest;
import com.task.task.request.task.UpdateTaskRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(UUID id) {
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
    }

    @Override
    public Task createTask(CreateTaskRequest createTaskRequest) {
        return taskRepository.save(createTaskRequest.toTask());
    }

    @Override
    public Task updateTask(UUID id, UpdateTaskRequest updateTaskRequest) {
        return null;
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
