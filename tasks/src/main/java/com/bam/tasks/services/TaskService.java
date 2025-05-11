package com.bam.tasks.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bam.tasks.entities.Task;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);

    Task createTask(UUID taskListId, Task newTask);

    Optional<Task> getTaskById(UUID taskListId, UUID taskId);

    Task updateTask(UUID taskListId, UUID taskId, Task task);

    void deleteTask(UUID taskListId, UUID taskId);
}
