package org.example.entity.gateway;

import org.example.entity.model.Sprint;

import java.util.List;
import java.util.Optional;

public interface SprintGateway {

    Sprint create(Sprint sprint);
    Sprint update(Sprint sprint);
    void delete(Long id);
    Optional<Sprint> findById(Long id);
    List<Sprint> findAll();
}
