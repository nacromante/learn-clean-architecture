package org.example.infrastructure.controller;

import jakarta.validation.Valid;
import org.example.infrastructure.dto.EpicPublicDto;
import org.example.infrastructure.dto.EpicRegistrationDto;
import org.example.infrastructure.dto.EpicPublicDto;
import org.example.infrastructure.dto.EpicRegistrationDto;
import org.example.usecase.CreateEpicUseCase;
import org.example.usecase.CreateEpicUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateEpicController {

    private final CreateEpicUseCase createEpicUserCase;

    public CreateEpicController(CreateEpicUseCase createEpicUserCase) {
        this.createEpicUserCase = createEpicUserCase;
    }

    @PostMapping("/epics")
    @ResponseStatus(HttpStatus.CREATED)
    public EpicPublicDto create(@Valid @RequestBody EpicRegistrationDto dto) {
        return new EpicPublicDto(createEpicUserCase.execute(dto));
    }

}