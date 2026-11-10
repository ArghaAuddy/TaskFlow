package com.taskflow.dto.request;

import com.taskflow.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {
    @NotBlank(message="Task title is required")
    @Size(max=150,message="Title cannot exceed 150 characters")
    private String title;

    @Size(max=1000,message="Description cannot exceed 1000 characters")
    private String description;

    @NotNull(message="Priority is required")
    private Priority priority;

    public TaskRequest()
    {
    }
}
