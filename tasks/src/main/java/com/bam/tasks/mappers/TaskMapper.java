package com.bam.tasks.mappers;

import com.bam.tasks.dto.TaskDto;
import com.bam.tasks.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);

}
