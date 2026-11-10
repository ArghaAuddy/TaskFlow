package com.taskflow.controller;


import com.taskflow.dto.request.TaskRequest;
import com.taskflow.dto.response.TaskResponse;
import com.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }
    // Create a task
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest request)
    {
        TaskResponse response=taskService.createTask(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // Get all tasks
    @GetMapping
    public ResponseEntity<List<TaskResponse>>getAllTasks()
    {
        List<TaskResponse> tasks=taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // Get task by id
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id)
    {
        TaskResponse response=taskService.getTaskById(id);
        return ResponseEntity.ok(response);
    }

    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id)
    {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id,@Valid @RequestBody TaskRequest request)
    {
      TaskResponse response=taskService.updateTask(id,request);

      return ResponseEntity.ok(response);
    }

}
