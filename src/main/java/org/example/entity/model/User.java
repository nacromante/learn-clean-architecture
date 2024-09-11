package org.example.entity.model;

import org.example.entity.AbstractEntity;

public class User extends AbstractEntity<Long> {

    private String name;

    public User() {
    }

    public User(Long id, String name) {
        super.setId(id);
        this.name = name;
    }

    public User(Long id) {
        super.setId(id);
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
