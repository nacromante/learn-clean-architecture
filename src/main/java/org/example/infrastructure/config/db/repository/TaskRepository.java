package org.example.infrastructure.config.db.repository;

import org.example.infrastructure.config.db.schema.TaskSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskSchema, Long> {

}