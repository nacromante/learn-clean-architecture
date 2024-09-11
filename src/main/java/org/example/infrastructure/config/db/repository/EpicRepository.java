package org.example.infrastructure.config.db.repository;

import org.example.infrastructure.config.db.schema.EpicSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicRepository extends JpaRepository<EpicSchema, Long> {

}