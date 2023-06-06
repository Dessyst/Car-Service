package com.example.demo.controller;

import com.example.demo.controller.resources.CarResource;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor

public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(carService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CarResource carResource) {
        CarResource saved = carService.save(carResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/cars/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CarResource carResource, @PathVariable int id) {
        return ResponseEntity.ok(carService.update(carResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        carService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
