package org.example.infrastructure.dto;

import org.example.entity.model.Epic;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.IEpicPublicData;

public record EpicPublicDto(
        Long id,
        String title,
        String description,
        ProgressStatus status
       ) implements IEpicPublicData {
       public EpicPublicDto(Epic epic) {
           this(epic.getId(), epic.getTitle(), epic.getDescription(), epic.getStatus());
       }
}