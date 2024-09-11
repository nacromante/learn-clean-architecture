package org.example.infrastructure.config.db.schema;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.model.Epic;
import org.example.entity.model.Story;
import org.example.entity.model.User;
import org.example.infrastructure.config.db.enums.ProgressStatus;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "story")
public class StorySchema extends AbstractEntitySchema<Long> {

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
    @JoinColumn(name = "epic")
    private EpicSchema epicSchema;

    @ManyToOne
    @JoinColumn(name = "responsible")
    private UserSchema responsible;

    @OneToMany(mappedBy = "storySchema")
    private List<TaskSchema> taskSchemas;

    public StorySchema(Long id) {
        super.setId(id);
    }

    public StorySchema(Story story) {
        this.description = story.getDescription();
        this.title = story.getTitle();
        this.points = story.getPoints();
        this.status = story.getStatus();
        if(story.getEpic() != null)
            this.epicSchema = new EpicSchema(story.getEpic().getId());
        if(story.getResponsible() != null)
            this.responsible = new UserSchema  (story.getResponsible().getId());
        this.taskSchemas = Optional.ofNullable(story.getTasks())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(TaskSchema::new)
                .toList();
    }

    public Story toStory() {
        User user = Optional.ofNullable(this.responsible).map(r -> new User(r.getId())).orElse(null);
        return new Story(super.getId(),this.description, this.title, this.points, this.status,
                new Epic(this.epicSchema.getId()), user, this.taskSchemas.stream().map(TaskSchema::toTask).toList());
    }
}
