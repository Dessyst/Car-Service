package com.example.demo.mapper;

import com.example.demo.controller.resources.ServiceResource;
import com.example.demo.entity.Service;

import java.util.List;
public interface ServiceMapper {
    ServiceMapper SUBJECT_MAPPER = Mappers.getMapper(ServiceMapper.class);

    Service fromServiceResource(ServiceResource resource);

    ServiceResource toServiceResource(Service service);

    List<ServiceResource> toServiceResources(List<Service> services);
}
