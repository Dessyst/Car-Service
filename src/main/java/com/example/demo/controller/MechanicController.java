package com.example.demo.controller;

import com.example.demo.controller.resources.MechanicResource;
import com.example.demo.service.MechanicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("api/v1/mechanics")
@RequiredArgsConstructor

public class MechanicController {
    private final MechanicService mechanicService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(mechanicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(mechanicService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MechanicResource mechanicResource) {
        MechanicResource saved = mechanicService.save(mechanicResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/mechanics/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody MechanicResource mechanicResource, @PathVariable int id) {
        return ResponseEntity.ok(mechanicService.update(mechanicResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        mechanicService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
