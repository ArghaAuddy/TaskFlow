package com.taskflow.dto.response;

import com.taskflow.enums.Priority;
import com.taskflow.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private TaskStatus status;
    private LocalDateTime createdAt;
    public TaskResponse()
    {}

    public TaskResponse(
            Long id,
            String title,
            String description,
            Priority priority,
            TaskStatus status,
            LocalDateTime createdAt
    )
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
    }
}
