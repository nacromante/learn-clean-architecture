package org.example.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.usecase.dto.IEpicRegistrationData;
import org.example.usecase.dto.ISprintRegistrationData;

import java.time.LocalDate;
import java.util.List;

public record EpicRegistrationDto(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        Long sprintId
       ) implements IEpicRegistrationData { }