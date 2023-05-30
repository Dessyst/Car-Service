package com.example.demo.service.impl;

import com.example.demo.controller.resources.OrderResource;
import com.example.demo.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public List<OrderResource> getAll() {
        return ORDER_MAPPER.toMealResources(orderRepository.findAll());
    }


    @Override
    public void delete(Long id) {
        mealRepository.deleteById(id);
    }
}
