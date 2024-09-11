package org.example.infrastructure.config.db.repository;

import org.example.infrastructure.config.db.schema.EpicSchema;
import org.example.infrastructure.config.db.schema.StorySchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StorySchema, Long> {

}