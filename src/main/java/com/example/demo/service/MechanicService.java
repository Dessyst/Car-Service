package com.example.demo.service;


import com.example.demo.controller.resources.MechanicResource;

import java.util.List;

public interface MechanicService {
    List<MechanicResource> findAll();

    MechanicResource getById(int id);

    MechanicResource save(MechanicResource mechanic);

    MechanicResource update(MechanicResource mechanicResource, int id);

    void delete(int id);

}
