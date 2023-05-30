package com.example.demo.controller.resources;

import lombok.Data;

@Data
public class PaymentResource {
    private Long id;
    private OrderResource order;
    private ClientResource client;
    private MechanicResource mechanic;

}
