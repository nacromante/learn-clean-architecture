package org.example.infrastructure.config.db.schema;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.model.Epic;
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
@Table(name = "epic")
public class EpicSchema extends AbstractEntitySchema<Long> {

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ProgressStatus status;

    @OneToMany(mappedBy = "epicSchema")
    private List<StorySchema> stories;

    @ManyToOne
    @JoinColumn(name = "sprint")
    private SprintSchema sprintSchema;

    public EpicSchema(Epic epic) {
        this.description = epic.getDescription();
        this.title = epic.getTitle();
        this.status = epic.getStatus();
        this.stories = Optional.ofNullable(epic.getStories())
                .orElseGet(Collections::emptyList)
                .stream()
                .map(StorySchema::new)
                .toList();
        this.sprintSchema = new SprintSchema(epic.getSprint().getId());
    }

    public EpicSchema(Long id) {
        super.setId(id);
    }

    public Epic toEpic() {
        return new Epic(super.getId(),this.description, this.title, this.status,
                Optional.ofNullable(this.stories)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(StorySchema::toStory)
                        .toList(),
                this.sprintSchema.toSprint());
    }
}
