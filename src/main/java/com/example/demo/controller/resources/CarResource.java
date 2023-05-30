package com.example.demo.controller.resources;

import lombok.Data;
@Data
public class CarResource {
    private Long id;
    private String model;
    private String licensePlate;
    private ClientResorce client;


}
