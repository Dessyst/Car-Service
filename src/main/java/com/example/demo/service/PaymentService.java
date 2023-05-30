package com.example.demo.service;

import com.example.demo.controller.resources.PaymentResource;

import java.util.List;

public interface PaymentService {
    List<PaymentResource> findAll();

    PaymentResource getById(int id);

    PaymentResource save(PaymentResource payment);

    PaymentResource update(PaymentResource paymentResource, int id);

    void delete(int id);
}
