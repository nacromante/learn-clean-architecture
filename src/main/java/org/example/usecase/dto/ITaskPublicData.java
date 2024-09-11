package org.example.usecase.dto;

import org.example.infrastructure.config.db.enums.ProgressStatus;

public interface ITaskPublicData {
    String title();
    String description();
    Integer points();
    ProgressStatus status();
}
