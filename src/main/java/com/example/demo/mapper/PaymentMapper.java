package com.example.demo.mapper;

import com.example.demo.controller.resources.PaymentResource;
import com.example.demo.entity.Payment;

import java.util.List;
public interface PaymentMapper {
    PaymentMapper SUBJECT_MAPPER = Mappers.getMapper(PaymentMapper.class);

    Payment fromPaymentResource(PaymentResource resource);

    PaymentResource toPaymentResource(Payment payment);

    List<PaymentResource> toPaymentResources(List<Payment> payments);
}
