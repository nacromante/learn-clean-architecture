package org.example.entity.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.AbstractEntity;
import org.example.infrastructure.config.db.enums.SprintStatus;
import org.example.infrastructure.config.db.schema.AbstractEntitySchema;

import java.time.LocalDate;
import java.util.List;

public class Sprint extends AbstractEntity<Long> {

    private String title;

    private SprintStatus sprintStatus;

    private LocalDate endDate;

    private LocalDate beginDate;

    private List<Epic> epics;

    public Sprint() {
    }

    public Sprint(String title, LocalDate endDate, LocalDate beginDate) {
        this.title = title;
        this.endDate = endDate;
        this.beginDate = beginDate;
    }

    public Sprint(Long id, String title, LocalDate endDate, LocalDate beginDate, List<Epic> epics) {
        super.setId(id);
        this.title = title;
        this.endDate = endDate;
        this.beginDate = beginDate;
        this.epics = epics;
    }

    public Sprint(Long id) {
        super.setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SprintStatus getSprintStatus() {
        return sprintStatus;
    }

    public void setSprintStatus(SprintStatus sprintStatus) {
        this.sprintStatus = sprintStatus;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public List<Epic> getEpics() {
        return epics;
    }

    public void setEpics(List<Epic> epics) {
        this.epics = epics;
    }
}
