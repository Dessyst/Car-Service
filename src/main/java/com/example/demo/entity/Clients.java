package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Clients {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String EGN;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
