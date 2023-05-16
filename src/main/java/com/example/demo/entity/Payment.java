package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Payment {
    @OneToOne
    Order order;
    @ManyToOne
    Clients client;
    @ManyToOne
    Mechanics mechanic;
    int price;
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

}
