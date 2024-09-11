package org.example.infrastructure.dto;

import org.example.entity.model.Epic;
import org.example.entity.model.Sprint;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.IEpicPublicData;
import org.example.usecase.dto.IEpicRegistrationData;
import org.example.usecase.dto.ISprintPublicData;

import java.time.LocalDate;

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