package org.example.infrastructure.gateway;

import org.example.entity.gateway.EpicGateway;
import org.example.entity.model.Epic;
import org.example.infrastructure.config.db.repository.EpicRepository;
import org.example.infrastructure.config.db.schema.EpicSchema;

import java.util.List;
import java.util.Optional;

public class EpicDatabaseGateway implements EpicGateway {

    private final EpicRepository epicRepository;

    public EpicDatabaseGateway(EpicRepository epicRepository) {
        this.epicRepository = epicRepository;
    }

    @Override
    public Epic create(Epic epic) {
        return this.epicRepository.save(new EpicSchema(epic)).toEpic();
    }

    @Override
    public Epic update(Epic epic) {
        return this.epicRepository.save(new EpicSchema(epic)).toEpic();
    }

    @Override
    public void delete(Long id) {
        this.epicRepository.deleteById(id);
    }

    @Override
    public Optional<Epic> findById(Long id) {
        return epicRepository
                .findById(id)
                .map(EpicSchema::toEpic);
    }


    @Override
    public List<Epic> findAll() {
        return epicRepository
                .findAll()
                .stream()
                .map(EpicSchema::toEpic)
                .toList();
    }
}