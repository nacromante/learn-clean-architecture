package org.example.entity.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.AbstractEntity;
import org.example.infrastructure.config.db.enums.ProgressStatus;
import org.example.infrastructure.config.db.schema.AbstractEntitySchema;

import java.util.List;

public class Epic extends AbstractEntity<Long> {

    private String description;

    private String title;

    private ProgressStatus status;

    private List<Story> stories;

    private Sprint sprint;

    public Epic(Long id, String description, String title, ProgressStatus status, List<Story> stories, Sprint sprint) {
        super.setId(id);
        this.description = description;
        this.title = title;
        this.status = status;
        this.stories = stories;
        this.sprint = sprint;
    }

    public Epic(String title, String description, ProgressStatus status, Sprint sprint) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.sprint = sprint;
    }

    public Epic(Long id) {
        super.setId(id);
    }

    public Epic() {
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

    public ProgressStatus getStatus() {
        return status;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
}
