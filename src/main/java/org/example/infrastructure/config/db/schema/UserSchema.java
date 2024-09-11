package org.example.infrastructure.config.db.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.example.entity.model.User;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_responsible")
public class UserSchema extends AbstractEntitySchema<Long> {

    @Column(name = "name")
    private String name;

    public UserSchema(Long id) {
        super.setId(id);
    }

    public UserSchema(User responsible) {
        if(responsible.getName() != null)
            this.name = responsible.getName();
    }

    public User toUser() {
        return new User(this.getId(), this.name);
    }
}
