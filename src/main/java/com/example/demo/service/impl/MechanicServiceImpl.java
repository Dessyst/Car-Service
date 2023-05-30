package com.example.demo.service.impl;

import com.example.demo.controller.resources.CarResource;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.MechanicsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor

import java.util.List;

public class MechanicServiceImpl {
    private final MechanicsRepository mechanicsRepository;

    @Override
    public List<CarResource> findAll() {
        return CAR_MAPPER.toSubjectResources(mechanicsRepository.findAll());
    }

    @Override
    public CarResource getById(long id) {
        return CAR_MAPPER.toSubjectResource(mechanicsRepository.getReferenceById(id));
    }

    @Override
    public CarResource save(CarResource car) {
        Car car = CAR_MAPPER.fromSubjectResource(resource);
        car.setCars(null);

        return CAR_MAPPER.toSubjectResource(mechanicsRepository.save(car));
    }

    @Override
    public CarResource update(CarResource carResource, long id) {
        Car toUpdate = mechanicsRepository.getReferenceById(id);
        toUpdate.setName(carResource.getName());

        return CAR_MAPPER.toSubjectResource(mechanicsRepository.save(toUpdate));
    }

    @Override
    public void delete(int id) {
        mechanicsRepository.deleteById((long) id);

    }
}
