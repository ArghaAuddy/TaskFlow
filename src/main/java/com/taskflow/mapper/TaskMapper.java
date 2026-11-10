package com.taskflow.mapper;

import com.taskflow.dto.request.TaskRequest;
import com.taskflow.dto.response.TaskResponse;
import com.taskflow.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    // Convert RequestDTO into Entity
    public Task toEntity(TaskRequest taskRequest)
    {
        Task task=new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());

        return task;
    }

    // Convert Entity into Response DTO
    public TaskResponse toResponse(Task task)
    {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }

}
