package org.example.usecase;

import org.example.entity.gateway.UserGateway;
import org.example.entity.model.Story;
import org.example.entity.model.User;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.usecase.dto.IUserRegistrationData;

public class CreateUserUseCase {

    private final UserGateway userGateway;

    public CreateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(IUserRegistrationData iUser) {
        User task = new User(iUser.name());
        return userGateway.create(task);
    }
}
