package com.example.demo.mapper;

import com.example.demo.controller.resources.OrderResource;
import com.example.demo.entity.Order;

import java.util.List;
public interface OrderMapper {
    OrderMapper SUBJECT_MAPPER = Mappers.getMapper(OrderMapper.class);

    Order fromOrderResource(OrderResource resource);

    OrderResource toOrderResource(Order order);

    List<OrderResource> toOrderResources(List<Order> orders);
}
