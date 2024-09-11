package org.example.usecase;

import org.example.entity.gateway.StoryGateway;
import org.example.entity.model.Epic;
import org.example.entity.model.Story;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.IStoryRegistrationData;

public class CreateStoryUseCase {

    private final StoryGateway epicGateway;

    public CreateStoryUseCase(StoryGateway epicGateway) {
        this.epicGateway = epicGateway;
    }

    public Story execute(IStoryRegistrationData iStory) {
        Epic epic = new Epic(iStory.epicId());
        Story story = new Story(iStory.title(), iStory.description(), iStory.points(), ProgressStatus.TODO, epic);
        return epicGateway.create(story);
    }
}
