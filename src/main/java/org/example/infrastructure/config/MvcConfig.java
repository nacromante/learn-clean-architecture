package org.example.infrastructure.config;

import org.example.entity.gateway.*;
import org.example.infrastructure.config.db.repository.*;
import org.example.infrastructure.gateway.*;
import org.example.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class MvcConfig {

  @Bean
  public LocaleResolver sessionLocaleResolver() {
    return new AcceptHeaderResolver();
  }

  @Bean
  public CreateSprintUseCase createSprintUseCase(SprintRepository sprintRepository) {
    SprintGateway customerGateway = new SprintDatabaseGateway(sprintRepository);
    return new CreateSprintUseCase(customerGateway);
  }
  @Bean
  public CreateEpicUseCase createEpicUseCase(EpicRepository sprintRepository) {
    EpicGateway customerGateway = new EpicDatabaseGateway(sprintRepository);
    return new CreateEpicUseCase(customerGateway);
  }
  @Bean
  public CreateStoryUseCase createStoryUseCase(StoryRepository storyRepository) {
    StoryGateway customerGateway = new StoryDatabaseGateway(storyRepository);
    return new CreateStoryUseCase(customerGateway);
  }
  @Bean
  public CreateTaskUseCase createTaskUseCase(TaskRepository taskRepository) {
    TaskGateway customerGateway = new TaskDatabaseGateway(taskRepository);
    return new CreateTaskUseCase(customerGateway);
  }
  @Bean
  public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
    UserGateway customerGateway = new UserDatabaseGateway(userRepository);
    return new CreateUserUseCase(customerGateway);
  }

}