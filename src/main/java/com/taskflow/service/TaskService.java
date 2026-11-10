package com.taskflow.service;

import com.taskflow.dto.request.TaskRequest;
import com.taskflow.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    void deleteTask(Long id);
    TaskResponse updateTask(Long id, TaskRequest request);

}
