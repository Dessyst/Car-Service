package com.example.demo.controller.resources;

import lombok.Data;

@Data
public class OrderResource {
    private Long id;
    private CarResource car;
    private MechanicResource mechanic;
    private ServiceResource service;
}
