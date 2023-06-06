package com.example.demo.controller;

import com.example.demo.controller.resources.PaymentResource;
import com.example.demo.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/payments")
@RequiredArgsConstructor

public class PaymentController {
    private final PaymentService paymentService;


    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PaymentResource paymentResource) {
        PaymentResource saved = paymentService.save(paymentResource);
        return ResponseEntity.created(
                        UriComponentsBuilder.fromPath("/payments/{id}").buildAndExpand(saved.getId()).toUri())
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody PaymentResource paymentResource, @PathVariable int id) {
        return ResponseEntity.ok(paymentService.update(paymentResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        paymentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
