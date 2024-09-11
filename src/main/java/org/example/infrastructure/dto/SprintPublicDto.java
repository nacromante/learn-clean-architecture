package org.example.infrastructure.dto;

import org.example.entity.model.Sprint;
import org.example.usecase.dto.ISprintPublicData;

import java.time.LocalDate;

public record SprintPublicDto(
        Long id,
        String title,
        LocalDate endDate,
        LocalDate beginDate
       ) implements ISprintPublicData {
       public SprintPublicDto(Sprint sprint) {
           this(sprint.getId(), sprint.getTitle(), sprint.getEndDate(), sprint.getBeginDate());
       }
}