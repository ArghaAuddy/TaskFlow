package com.taskflow.service;

import com.taskflow.dto.request.TaskRequest;
import com.taskflow.dto.response.TaskResponse;
import com.taskflow.entity.Task;
import com.taskflow.exception.ResourceNotFoundException;
import com.taskflow.mapper.TaskMapper;
import com.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(
            TaskRepository taskRepository,
            TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponse createTask(TaskRequest request) {
        Task task = taskMapper.toEntity(request);
        Task savedTask = taskRepository.save(task);

        return taskMapper.toResponse(savedTask);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task not found with id: " + id));

        return taskMapper.toResponse(task);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }

        taskRepository.deleteById(id);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task not found with id: " + id
                        ));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());

        Task updatedTask = taskRepository.save(task);

        return taskMapper.toResponse(updatedTask);
    }
}