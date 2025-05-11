package com.bam.tasks.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bam.tasks.dao.TaskListRepository;
import com.bam.tasks.dao.TaskRepository;
import com.bam.tasks.entities.Task;
import com.bam.tasks.entities.TaskList;
import com.bam.tasks.entities.TaskPriority;
import com.bam.tasks.entities.TaskStatus;
import com.bam.tasks.services.TaskService;

import jakarta.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Transactional
    @Override
    public Task createTask(UUID taskListId, Task newTask) {
        if (null != newTask.getId()) {
            throw new IllegalArgumentException("Task already has an Id");
        }
        if (null == newTask.getTitle() || newTask.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task must have a title !");
        }
        TaskPriority taskPriority = Optional.ofNullable(newTask
                .getPriority()).orElse(TaskPriority.MEDIUM);

        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList = taskListRepository.findById(taskListId).orElseThrow(
                () -> new IllegalArgumentException("Invalid taskList Id!"));
        LocalDateTime now = LocalDateTime.now();
        Task taskToSave = new Task(
                null,
                newTask.getTitle(),
                newTask.getDescription(),
                newTask.getDueDate(),
                taskStatus,
                taskPriority,
                taskList,
                now,
                now);
        return taskRepository.save(taskToSave);
    }

    @Override
    public Optional<Task> getTaskById(UUID taskListId, UUID taskId) {
        return taskRepository.findByTaskListIdAndId(taskListId, taskId);
    }

    @Transactional
    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {
        if (null == task.getId()) {
            throw new IllegalArgumentException("Task Must have an Id");
        }
        if (!Objects.equals(taskId, task.getId())) {
            throw new IllegalArgumentException("Task id do not match");
        }
        if (null == task.getPriority()) {
            throw new IllegalArgumentException("Task Must have an valid Priority");
        }
        if (null == task.getStatus()) {
            throw new IllegalArgumentException("Task Must have an valid Status");
        }

        Task updatedTask = taskRepository.findByTaskListIdAndId(taskListId, taskId)
                .orElseThrow(() -> new IllegalArgumentException("task not found"));

        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setDueDate(task.getDueDate());
        updatedTask.setPriority(task.getPriority());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setUpdated(LocalDateTime.now());

        return taskRepository.save(updatedTask);

    }

    @Transactional
    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {
        taskRepository.deleteByTaskListIdAndId(taskListId, taskId);
    }

}
