package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Car {
    @Id
    @GeneratedValue
    private Long id;

    private String model;
    private String licensePlate;

    @ManyToOne
    private Clients client;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCars(Object o) {

    }
}
