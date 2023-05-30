package com.example.demo.mapper;

import com.example.demo.controller.resources.MechanicResource;
import com.example.demo.entity.Mechanics;

import java.util.List;
public interface MechanicMapper {
    MechanicMapper SUBJECT_MAPPER = Mappers.getMapper(MechanicMapper.class);

    Mechanics fromMechanicResource(MechanicResource resource);

    MechanicResource toMechanicResource(Mechanics mechanic);

    List<MechanicResource> toMechanicResources(List<Mechanics> mechanic);
}
