package com.example.demo.service;

i
import com.example.demo.repository.CarRepository;
import com.example.demo.entity.Car;
import com.example.demo.controller.resources.CarResource;

import java.util.List;

public interface CarService {
    List<CarResource> findAll();

    CarResource getById(long id);

    CarResource save(CarResource car);

    CarResource update(CarResource carResource, long id);

    //Optional<Car> getSubjectByName(String name);

    void delete(int id);
}
