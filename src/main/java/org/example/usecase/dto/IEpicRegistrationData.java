package org.example.usecase.dto;

import org.example.entity.model.Epic;
import org.example.entity.model.Sprint;
import org.example.entity.model.Story;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.infrastructure.config.db.enums.SprintStatus;

import java.time.LocalDate;
import java.util.List;

public interface IEpicRegistrationData {
    String title();
    String description();
    Long sprintId();
}
