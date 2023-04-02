package com.backend.deluxevision.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Category implements Serializable {

    @Id
    @Column(nullable = false,updatable = false)
    private String name;
    private String description;

    public Category() {
        // Default constructor
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
