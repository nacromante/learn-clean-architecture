package org.example.infrastructure.controller;

import jakarta.validation.Valid;
import org.example.infrastructure.dto.SprintPublicDto;
import org.example.infrastructure.dto.SprintRegistrationDto;
import org.example.usecase.CreateSprintUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateSprintController {

    private final CreateSprintUseCase createSprintUserCase;

    public CreateSprintController(CreateSprintUseCase createSprintUserCase) {
        this.createSprintUserCase = createSprintUserCase;
    }

    @PostMapping("/sprints")
    @ResponseStatus(HttpStatus.CREATED)
    public SprintPublicDto create(@Valid @RequestBody SprintRegistrationDto dto) {
        return new SprintPublicDto(createSprintUserCase.execute(dto));
    }

}