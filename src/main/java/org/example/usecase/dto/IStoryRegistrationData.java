package org.example.usecase.dto;

import org.example.entity.model.Story;
import org.example.entity.model.Task;
import org.example.infrastructure.config.db.enums.ProgressStatus;

import java.util.List;

public interface IStoryRegistrationData {
    String title();
    String description();
    Integer points();
    Long epicId();
}
