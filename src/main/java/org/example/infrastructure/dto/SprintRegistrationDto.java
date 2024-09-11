package org.example.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.usecase.dto.ISprintRegistrationData;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record SprintRegistrationDto(
        @NotBlank
        String title,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate endDate,
        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate beginDate
       ) implements ISprintRegistrationData { }