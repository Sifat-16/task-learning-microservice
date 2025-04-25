package com.task.task.controller.task;

import com.task.task.model.task.Task;
import com.task.task.request.task.CreateTaskRequest;
import com.task.task.request.task.UpdateTaskRequest;
import com.task.task.response.ApiResponse;
import com.task.task.service.task.TaskService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import reactor.netty.http.server.HttpServerRequest;

import java.util.UUID;

@RestController
@RequestMapping(value = "/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<ApiResponse> fetchAllTasks(HttpServletRequest http) {

        try {
            return ResponseEntity.ok(new ApiResponse("All Tasks", taskService.getAllTasks()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No task available", e.getMessage()));
        }
    }

    @PostMapping(value = "/create-task")
    public ResponseEntity<ApiResponse> createTask(@ModelAttribute CreateTaskRequest createTaskRequest) {
        try {
            return ResponseEntity.ok(new ApiResponse("Task Created Successfully", taskService.createTask(createTaskRequest)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Failed to create task", e.getMessage()));
        }
    }

    @GetMapping(value = "/get-task-by-id/{id}")
    public ResponseEntity<ApiResponse> getTaskById(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(new ApiResponse("Task Found", taskService.getTaskById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Task not Found", e.getMessage()));
        }
    }

    @PutMapping(value = "/update-task/{id}")
    public ResponseEntity<ApiResponse> updateTask(@PathVariable UUID id, @ModelAttribute UpdateTaskRequest updateTaskRequest) {
        try {
            return ResponseEntity.ok(new ApiResponse("Task Update Successfully", taskService.updateTask(id, updateTaskRequest)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Something went wrong!", e.getMessage()));
        }
    }

    @DeleteMapping(value = "/delete-task/{id}")
    public ResponseEntity<ApiResponse> deleteTask(@PathVariable UUID id){
        try{
            return ResponseEntity.ok(new ApiResponse("Task Deleted Successfully", taskService.deleteTask(id)));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Something went wrong!", e.getMessage()));
        }
    }


    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){ // CsrfToken provide by spring security.
        // How generate token
        return (CsrfToken)request.getAttribute("_csrf");
    }

}
