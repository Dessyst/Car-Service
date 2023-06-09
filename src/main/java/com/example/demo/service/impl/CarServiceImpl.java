package com.example.demo.service.impl;

import com.example.demo.controller.resources.CarResource;
import com.example.demo.entity.Car;
import com.example.demo.mapper.CarMapper.CAR_MAPPER;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<CarResource> findAll() {
        return CAR_MAPPER.toSubjectResources(carRepository.findAll());
    }

    @Override
    public CarResource getById(long id) {
        return CAR_MAPPER.toSubjectResource(carRepository.getReferenceById(id));
    }

    @Override
    public CarResource save(CarResource car) {
        Car car = CAR_MAPPER.fromSubjectResource(resource);
        car.setCars(null);

        return CAR_MAPPER.toSubjectResource(carRepository.save(car));
    }

    @Override
    public CarResource update(CarResource carResource, long id) {
        Car toUpdate = carRepository.getReferenceById(id);
        toUpdate.setName(carResource.getName());

        return CAR_MAPPER.toSubjectResource(carRepository.save(toUpdate));
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById((long) id);

    }

}
