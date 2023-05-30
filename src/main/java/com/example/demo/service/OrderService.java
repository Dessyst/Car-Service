package com.example.demo.service;

import com.example.demo.controller.resources.OrderResource;

import java.util.List;

public interface OrderService {
    List<OrderResource> findAll();

    OrderResource getById(int id);

    OrderResource save(OrderResource order);

    OrderResource update(OrderResource orderResource, int id);

    void delete(int id);
}
