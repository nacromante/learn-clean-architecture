package org.example.infrastructure.controller;

import jakarta.validation.Valid;
import org.example.infrastructure.dto.StoryPublicDto;
import org.example.infrastructure.dto.StoryRegistrationDto;
import org.example.usecase.CreateStoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStoryController {

    private final CreateStoryUseCase createStoryUserCase;

    public CreateStoryController(CreateStoryUseCase createStoryUserCase) {
        this.createStoryUserCase = createStoryUserCase;
    }

    @PostMapping("/stories")
    @ResponseStatus(HttpStatus.CREATED)
    public StoryPublicDto create(@Valid @RequestBody StoryRegistrationDto dto) {
        return new StoryPublicDto(createStoryUserCase.execute(dto));
    }

}