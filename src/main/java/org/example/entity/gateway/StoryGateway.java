package org.example.entity.gateway;

import org.example.entity.model.Story;

import java.util.List;
import java.util.Optional;

public interface StoryGateway {

    Story create(Story story);
    Story update(Story story);
    void delete(Long id);
    Optional<Story> findById(Long id);
    List<Story> findAll();
}
