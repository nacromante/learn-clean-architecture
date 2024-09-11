package org.example.usecase.dto;

import org.example.entity.model.Task;
import org.example.infrastructure.config.db.enums.ProgressStatus;

import java.util.List;

public interface ITaskRegistrationData {
    String title();
    String description();
    Integer points();
    Long storyId();
    Long userId();
}
