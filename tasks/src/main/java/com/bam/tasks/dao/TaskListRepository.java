package com.bam.tasks.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bam.tasks.entities.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID>{
    
}
