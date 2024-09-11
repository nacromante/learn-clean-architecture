package org.example.entity.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.AbstractEntity;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.infrastructure.config.db.schema.AbstractEntitySchema;

public class Task extends AbstractEntity<Long> {

    private String description;

    private String title;

    private Integer points;

    private ProgressStatus status;

    private Story story;

    private User responsible;

    public Task() {
    }
    public Task(Long id) {
        super.setId(id);
    }

    public Task(String description, String title, Integer points, ProgressStatus status, Story story, User responsible) {
        this.description = description;
        this.title = title;
        this.points = points;
        this.status = status;
        this.story = story;
        this.responsible = responsible;
    }
    public Task(Long id, String description, String title, Integer points, ProgressStatus status, Story story, User responsible) {
        super.setId(id);
        this.description = description;
        this.title = title;
        this.points = points;
        this.status = status;
        this.story = story;
        this.responsible = responsible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }
}
