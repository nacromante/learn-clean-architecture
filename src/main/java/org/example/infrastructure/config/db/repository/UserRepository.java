package org.example.infrastructure.config.db.repository;

import org.example.infrastructure.config.db.schema.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSchema, Long> {

}