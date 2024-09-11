package org.example.usecase;

import org.example.entity.gateway.TaskGateway;
import org.example.entity.model.Story;
import org.example.entity.model.Task;
import org.example.entity.model.User;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.ITaskRegistrationData;

import java.util.Optional;

public class CreateTaskUseCase {

    private final TaskGateway epicGateway;

    public CreateTaskUseCase(TaskGateway epicGateway) {
        this.epicGateway = epicGateway;
    }

    public Task execute(ITaskRegistrationData iTask) {
        Story story = Optional.ofNullable(iTask.storyId()).map(Story::new).orElse(null);
        User user = Optional.ofNullable(iTask.userId()).map(User::new).orElse(null);
        Task task = new Task(iTask.title(), iTask.description(), iTask.points(), ProgressStatus.TODO, story,  user);
        return epicGateway.create(task);
    }
}
