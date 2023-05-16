package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity

public class Order {
    @ManyToOne
    private Car car;

    @ManyToOne
    private int ServiceId;
    private Date date;

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
