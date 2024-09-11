package org.example.infrastructure.gateway;

import org.example.entity.gateway.StoryGateway;
import org.example.entity.model.Story;
import org.example.infrastructure.config.db.repository.StoryRepository;
import org.example.infrastructure.config.db.schema.StorySchema;

import java.util.List;
import java.util.Optional;

public class StoryDatabaseGateway implements StoryGateway {

    private final StoryRepository storyRepository;

    public StoryDatabaseGateway(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public Story create(Story story) {
        return this.storyRepository.save(new StorySchema(story)).toStory();
    }

    @Override
    public Story update(Story story) {
        return this.storyRepository.save(new StorySchema(story)).toStory();
    }

    @Override
    public void delete(Long id) {
        this.storyRepository.deleteById(id);
    }

    @Override
    public Optional<Story> findById(Long id) {
        return storyRepository
                .findById(id)
                .map(StorySchema::toStory);
    }


    @Override
    public List<Story> findAll() {
        return storyRepository
                .findAll()
                .stream()
                .map(StorySchema::toStory)
                .toList();
    }
}