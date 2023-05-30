package com.example.demo.service;

import com.example.demo.controller.resources.ClientResource;

import java.util.List;

public interface ClientService {
    List<ClientResource> findAll();

    ClientResource getById(long id);

    ClientResource save(ClientResource client);

    ClientResource update(ClientResource clientResource, long id);

    void delete(int id);
}
