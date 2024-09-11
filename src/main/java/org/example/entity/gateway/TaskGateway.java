package org.example.entity.gateway;

import org.example.entity.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskGateway {

    Task create(Task task);
    Task update(Task task);
    void delete(Long id);
    Optional<Task> findById(Long id);
    List<Task> findAll();
}
