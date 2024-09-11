package org.example.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.usecase.dto.IStoryRegistrationData;
import org.example.usecase.dto.ITaskRegistrationData;

public record TaskRegistrationDto(
        @NotBlank
        String title,
        @NotBlank
        String description,
        Integer points,
        @NotNull
        Long storyId,
        Long userId
       ) implements ITaskRegistrationData { }