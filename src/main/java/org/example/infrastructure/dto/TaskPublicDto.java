package org.example.infrastructure.dto;

import org.example.entity.model.Task;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.IEpicPublicData;

public record TaskPublicDto(
        Long id,
        String title,
        String description,
        ProgressStatus status
       ) implements IEpicPublicData {
       public TaskPublicDto(Task task) {
           this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
       }
}