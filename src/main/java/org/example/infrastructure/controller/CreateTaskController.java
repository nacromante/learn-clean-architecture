package org.example.infrastructure.controller;

import jakarta.validation.Valid;
import org.example.infrastructure.dto.TaskPublicDto;
import org.example.infrastructure.dto.TaskRegistrationDto;
import org.example.usecase.CreateTaskUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTaskController {

    private final CreateTaskUseCase createTaskUserCase;

    public CreateTaskController(CreateTaskUseCase createTaskUserCase) {
        this.createTaskUserCase = createTaskUserCase;
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskPublicDto create(@Valid @RequestBody TaskRegistrationDto dto) {
        return new TaskPublicDto(createTaskUserCase.execute(dto));
    }

}