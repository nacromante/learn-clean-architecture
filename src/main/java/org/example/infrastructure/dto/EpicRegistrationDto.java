package org.example.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.usecase.dto.IEpicRegistrationData;

public record EpicRegistrationDto(
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotNull
        Long sprintId
       ) implements IEpicRegistrationData { }