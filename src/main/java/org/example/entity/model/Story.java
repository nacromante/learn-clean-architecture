package org.example.entity.model;

import org.example.entity.AbstractEntity;
import org.example.infrastructure.config.db.enums.ProgressStatus;

import java.util.List;

public class Story extends AbstractEntity<Long> {

    private String description;

    private String title;

    private Integer points;

    private ProgressStatus status;

    private Epic epic;

    private User responsible;

    private List<Task> tasks;

    public Story(Long id, String description, String title, Integer points, ProgressStatus status, Epic epic, User responsible, List<Task> tasks) {
        super.setId(id);
        this.description = description;
        this.title = title;
        this.points = points;
        this.status = status;
        this.epic = epic;
        this.responsible = responsible;
        this.tasks = tasks;
    }

    public Story(String description, String title, Integer points, ProgressStatus status, Epic epic) {
        this.description = description;
        this.title = title;
        this.points = points;
        this.status = status;
        this.epic = epic;
    }

    public Story() {
    }
    public Story(Long id) {
        super.setId(id);
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

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
