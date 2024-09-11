package org.example.usecase.dto;

import java.time.LocalDate;
import java.util.List;

public interface ISprintRegistrationData {
    String title();
    LocalDate endDate();
    LocalDate beginDate();
}
