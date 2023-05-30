package com.example.demo.service.impl;

import com.example.demo.controller.resources.ClientResource;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.ClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl {
    private final ClientsRepository clientsRepository;


    @Override
    public List<ClientResource> findAll() {
        return CLIENT_MAPPER.toClientResources(clientsRepository.findAll());
    }

    @Override
    public ClientResource getById(long id) {
        return CLIENT_MAPPER.toClientResource(clientsRepository.getReferenceById(id));
    }

    @Override
    public ClientResource save(ClientResource clientResource) {
        Client client = CLIENT_MAPPER.fromClientResource(clientResource);
        client.setClients(null);
        return CLIENT_MAPPER.toClientResource(clientsRepository.save(client));
    }

    @Override
    public ClientResource update(ClientResource clientResource, long id) {
        Client toUpdate = clientsRepository.getReferenceById(id);
        toUpdate.setName(clientResource.getName());

        return CLIENT_MAPPER.toClientResource(clientsRepository.save(toUpdate));
    }

    @Override
    public void delete(int id) {
        clientsRepository.deleteById((long) id);
    }

    }
