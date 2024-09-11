package org.example.infrastructure.dto;

import org.example.entity.model.Epic;
import org.example.entity.model.Story;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.IEpicPublicData;

public record StoryPublicDto(
        Long id,
        String title,
        String description,
        ProgressStatus status
       ) implements IEpicPublicData {
       public StoryPublicDto(Story story) {
           this(story.getId(), story.getTitle(), story.getDescription(), story.getStatus());
       }
}