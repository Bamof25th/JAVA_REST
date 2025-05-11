package com.bam.tasks.mappers;

import com.bam.tasks.dto.TaskListDto;
import com.bam.tasks.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
