package com.example.demo.service;

import com.example.demo.controller.resources.CarResource;

import java.util.List;

public interface CarService {
    List<CarResource> findAll();

    CarResource getById(long id);

    CarResource save(CarResource car);

    CarResource update(CarResource carResource, long id);

    void delete(int id);
}
