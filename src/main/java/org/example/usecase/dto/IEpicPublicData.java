package org.example.usecase.dto;

import org.example.infrastructure.config.db.enums.ProgressStatus;

public interface IEpicPublicData {
    String title();
    String description();
    ProgressStatus status();
}
