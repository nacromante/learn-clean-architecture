package org.example.infrastructure.config.db.schema;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.model.Story;
import org.example.entity.model.Task;
import org.example.entity.model.User;
import org.example.infrastructure.config.db.enums.ProgressStatus;

import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class TaskSchema extends AbstractEntitySchema<Long> {

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "points")
    private Integer points;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProgressStatus status;

    @ManyToOne
    @JoinColumn(name = "story")
    private StorySchema storySchema;

    @ManyToOne
    @JoinColumn(name = "responsible")
    private UserSchema responsible;

    public TaskSchema(Long id) {
        super.setId(id);
    }

    public TaskSchema(Task task) {
        this.description = task.getDescription();
        this.title = task.getTitle();
        this.points = task.getPoints();
        this.status = task.getStatus();
        if(task.getStory() != null)
            this.storySchema = new StorySchema(task.getStory().getId());
        if (task.getResponsible() != null)
            this.responsible = new UserSchema(task.getResponsible().getId());
    }
    public Task toTask() {
        User user = Optional.ofNullable(this.responsible).map(r -> new User(r.getId())).orElse(null);
        return new Task(this.getId(), this.description, this.title, this.points, this.status,
                new Story(this.storySchema.getId()), user);
    }
}
