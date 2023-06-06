package com.example.demo.controller;

import com.example.demo.controller.resources.ClientResource;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor

public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<?> getAll() { return ResponseEntity.ok(clientService.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) { return ResponseEntity.ok(clientService.getById(id)); }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientResource clientResource)
    {
        ClientResource saved = clientService.save(clientResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/clients/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody ClientResource clientResource)
    {
        return ResponseEntity.ok(clientService.update(clientResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id)
    {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
