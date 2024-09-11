package org.example.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.usecase.dto.IEpicRegistrationData;
import org.example.usecase.dto.IStoryRegistrationData;
import org.example.usecase.dto.ITaskRegistrationData;

import java.util.List;

public record StoryRegistrationDto(
        @NotBlank
        String title,
        @NotBlank
        String description,
        Integer points,
        @NotNull
        Long epicId
       ) implements IStoryRegistrationData { }