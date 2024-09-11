package org.example.usecase;

import org.example.entity.gateway.EpicGateway;
import org.example.entity.model.Epic;
import org.example.entity.model.Sprint;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.IEpicRegistrationData;

public class CreateEpicUseCase {

    private final EpicGateway epicGateway;

    public CreateEpicUseCase(EpicGateway epicGateway) {
        this.epicGateway = epicGateway;
    }

    public Epic execute(IEpicRegistrationData iEpic) {
        Epic epic = new Epic(iEpic.title(), iEpic.description(), ProgressStatus.TODO, new Sprint(iEpic.sprintId()));
        return epicGateway.create(epic);
    }
}
