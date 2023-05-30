package com.example.demo.mapper;

import com.example.demo.controller.resources.ClientResource;
import com.example.demo.entity.Clients;

import java.util.List;

public interface ClientMapper {
    ClientMapper SUBJECT_MAPPER = Mappers.getMapper(ClientMapper.class);

    Clients fromClientResource(Clients resource);

    ClientResource toClientResource(Clients client);

    List<ClientResource> toClientResources(List<Cliets> cliet);
}
