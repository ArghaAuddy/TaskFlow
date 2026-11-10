package com.taskflow.entity;

import com.taskflow.enums.Priority;
import com.taskflow.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@jakarta.persistence.Entity
@Table(name="tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable=false,length=150)
    private String title;

    @Column(length=1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime createdAt;

    public Task()
    {
    }
    @PrePersist
    protected void onCreate()
    {
        createdAt=LocalDateTime.now();

        if(status==null)
        {
            status=TaskStatus.TODO;
        }
        if(priority==null)
        {
            priority= Priority.MEDIUM;
        }
    }
}
