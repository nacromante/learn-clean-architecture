package org.example.infrastructure.gateway;

import org.example.entity.gateway.TaskGateway;
import org.example.entity.model.Task;
import org.example.infrastructure.config.db.repository.TaskRepository;
import org.example.infrastructure.config.db.schema.TaskSchema;

import java.util.List;
import java.util.Optional;

public class TaskDatabaseGateway implements TaskGateway {

    private final TaskRepository taskRepository;

    public TaskDatabaseGateway(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return this.taskRepository.save(new TaskSchema(task)).toTask();
    }

    @Override
    public Task update(Task task) {
        return this.taskRepository.save(new TaskSchema(task)).toTask();
    }

    @Override
    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository
                .findById(id)
                .map(TaskSchema::toTask);
    }


    @Override
    public List<Task> findAll() {
        return taskRepository
                .findAll()
                .stream()
                .map(TaskSchema::toTask)
                .toList();
    }
}