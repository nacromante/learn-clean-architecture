package org.example.usecase.dto;

import java.time.LocalDate;

public interface ISprintPublicData {
    String title();
    LocalDate endDate();
    LocalDate beginDate();
}
