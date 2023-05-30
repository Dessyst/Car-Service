package com.example.demo.mapper;

import com.example.demo.controller.resources.CarResource;
import com.example.demo.entity.Car;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public class CarMapper {
    CarMapper SUBJECT_MAPPER = Mappers.getMapper(CarMapper.class);

    Car fromCarResource(CarResource resource);

    CarResource toCarResource(Car car);

    List<CarResource> toCarResources(List<Car> cars);
}
