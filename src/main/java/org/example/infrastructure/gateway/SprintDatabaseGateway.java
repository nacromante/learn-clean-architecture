package org.example.infrastructure.gateway;

import org.example.entity.gateway.SprintGateway;
import org.example.entity.model.Sprint;
import org.example.infrastructure.config.db.repository.SprintRepository;
import org.example.infrastructure.config.db.schema.SprintSchema;

import java.util.List;
import java.util.Optional;

public class SprintDatabaseGateway implements SprintGateway {

    private final SprintRepository sprintRepository;

    public SprintDatabaseGateway(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @Override
    public Sprint create(Sprint sprint) {
        return this.sprintRepository.save(new SprintSchema(sprint)).toSprint();
    }

    @Override
    public Sprint update(Sprint sprint) {
        return this.sprintRepository.save(new SprintSchema(sprint)).toSprint();
    }

    @Override
    public void delete(Long id) {
        this.sprintRepository.deleteById(id);
    }

    @Override
    public Optional<Sprint> findById(Long id) {
        return sprintRepository
                .findById(id)
                .map(SprintSchema::toSprint);
    }


    @Override
    public List<Sprint> findAll() {
        return sprintRepository
                .findAll()
                .stream()
                .map(SprintSchema::toSprint)
                .toList();
    }
}