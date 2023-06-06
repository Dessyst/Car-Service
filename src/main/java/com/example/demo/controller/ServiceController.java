package com.example.demo.controller;

import com.example.demo.controller.resources.ServiceResource;
import com.example.demo.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor

public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(serviceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(serviceService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ServiceResource serviceResource) {
        ServiceResource saved = serviceService.save(serviceResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/services/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ServiceResource serviceResource, @PathVariable int id) {
        return ResponseEntity.ok(serviceService.update(serviceResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        serviceService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
