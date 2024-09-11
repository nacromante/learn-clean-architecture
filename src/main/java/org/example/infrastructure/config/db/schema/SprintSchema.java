package org.example.infrastructure.config.db.schema;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.model.Sprint;
import org.example.infrastructure.config.db.enums.SprintStatus;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sprint")
public class SprintSchema extends AbstractEntitySchema<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SprintStatus sprintStatus;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @OneToMany(mappedBy = "sprintSchema")
    private List<EpicSchema> epicSchemas;

    public SprintSchema(Long id) {
        super.setId(id);
    }

    public SprintSchema(Sprint sprint) {
        this.title = sprint.getTitle();
        this.sprintStatus = sprint.getSprintStatus();
        this.endDate = sprint.getEndDate();
        this.beginDate = sprint.getBeginDate();
    }

    public Sprint toSprint() {
        return new Sprint(super.getId(), this.title, this.endDate, this.beginDate,
                Optional.ofNullable(this.epicSchemas)
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(EpicSchema::toEpic)
                        .toList());
    }
}
