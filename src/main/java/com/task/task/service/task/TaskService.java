package com.task.task.service.task;

import com.task.task.model.task.Task;
import com.task.task.request.task.CreateTaskRequest;
import com.task.task.request.task.UpdateTaskRequest;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(UUID id);
    Task createTask(CreateTaskRequest createTaskRequest);
    Task updateTask(UUID id, UpdateTaskRequest updateTaskRequest);
    Boolean deleteTask(UUID id);
}
