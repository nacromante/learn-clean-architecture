package org.example.usecase.dto;

import java.time.LocalDate;

public interface ISprintRegistrationData {
    String title();
    LocalDate endDate();
    LocalDate beginDate();
}
