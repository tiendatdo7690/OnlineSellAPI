package com.example.demo.entitiesAPI;

import org.hibernate.annotations.Type;

import javax.persistence.Column;

public class RoleAPI {

    private Long id;

    private String name;

    public RoleAPI() {
    }

    public RoleAPI(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
