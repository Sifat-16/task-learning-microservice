package com.task.task.controller.task;

import com.task.task.request.task.CreateTaskRequest;
import com.task.task.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<Object> fetchAllTasks(){
        try {
            return ResponseEntity.ok(taskService.getAllTasks());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Task found");
        }
    }

    @PostMapping
    public ResponseEntity<Object> createTask(@ModelAttribute CreateTaskRequest createTaskRequest){
        try {
            return ResponseEntity.ok(taskService.createTask(createTaskRequest));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to create task");
        }
    }

}
