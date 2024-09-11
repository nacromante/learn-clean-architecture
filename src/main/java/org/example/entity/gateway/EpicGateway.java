package org.example.entity.gateway;

import org.example.entity.model.Epic;

import java.util.List;
import java.util.Optional;

public interface EpicGateway {

    Epic create(Epic epic);
    Epic update(Epic epic);
    void delete(Long id);
    Optional<Epic> findById(Long id);
    List<Epic> findAll();
}
