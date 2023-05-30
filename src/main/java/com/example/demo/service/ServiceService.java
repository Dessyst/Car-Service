package com.example.demo.service;

import com.example.demo.controller.resources.ServiceResource;

import java.util.List;

public interface ServiceService {
    List<ServiceResource> findAll();

    ServiceResource getById(int id);

    ServiceResource save(ServiceResource service);

    ServiceResource update(ServiceResource serviceResource, int id);

    void delete(int id);
}
