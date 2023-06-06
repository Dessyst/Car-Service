package com.example.demo.controller;

import com.example.demo.controller.resources.OrderResource;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderResource orderResource) {
        OrderResource saved = orderService.save(orderResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/orders/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody OrderResource orderResource, @PathVariable int id) {
        return ResponseEntity.ok(orderService.update(orderResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        orderService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
