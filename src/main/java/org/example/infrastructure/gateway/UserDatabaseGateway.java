package org.example.infrastructure.gateway;

import org.example.entity.gateway.UserGateway;
import org.example.entity.model.User;
import org.example.infrastructure.config.db.repository.UserRepository;
import org.example.infrastructure.config.db.schema.UserSchema;

import java.util.List;
import java.util.Optional;

public class UserDatabaseGateway implements UserGateway {

    private final UserRepository userRepository;

    public UserDatabaseGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(new UserSchema(user)).toUser();
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(new UserSchema(user)).toUser();
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository
                .findById(id)
                .map(UserSchema::toUser);
    }


    @Override
    public List<User> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserSchema::toUser)
                .toList();
    }
}