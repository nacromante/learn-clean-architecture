package org.example.entity.gateway;

import org.example.entity.model.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {

    User create(User user);
    User update(User user);
    void delete(Long id);
    Optional<User> findById(Long id);
    List<User> findAll();
}
