package com.bam.tasks.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.bam.tasks.entities.TaskPriority;
import com.bam.tasks.entities.TaskStatus;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate, 
        TaskPriority priority,
        TaskStatus status) {
}
