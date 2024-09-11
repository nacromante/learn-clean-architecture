package org.example.usecase.dto;

public interface ITaskRegistrationData {
    String title();
    String description();
    Integer points();
    Long storyId();
    Long userId();
}
