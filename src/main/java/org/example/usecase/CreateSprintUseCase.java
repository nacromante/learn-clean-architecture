package org.example.usecase;

import org.example.entity.gateway.SprintGateway;
import org.example.entity.model.Sprint;
import org.example.usecase.dto.ISprintRegistrationData;

public class CreateSprintUseCase {

    private final SprintGateway sprintGateway;

    public CreateSprintUseCase(SprintGateway sprintGateway) {
        this.sprintGateway = sprintGateway;
    }

    public Sprint execute(ISprintRegistrationData iSprint) {
        Sprint sprint = new Sprint(iSprint.title(), iSprint.endDate(), iSprint.beginDate());
        return sprintGateway.create(sprint);
    }
}
