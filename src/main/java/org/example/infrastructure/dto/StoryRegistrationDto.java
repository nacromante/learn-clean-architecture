package org.example.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.usecase.dto.IStoryRegistrationData;

public record StoryRegistrationDto(
        @NotBlank
        String title,
        @NotBlank
        String description,
        Integer points,
        @NotNull
        Long epicId
       ) implements IStoryRegistrationData { }