package com.example.paymentservice;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service public class PaymentEventListener {
 private final PaymentRepository repo;public PaymentEventListener(PaymentRepository r){repo=r;}
 @KafkaListener(topics="payment-created",groupId="payment-group") public void process(String id){repo.findById(Long.parseLong(id)).ifPresent(p->{if("PENDING".equals(p.getStatus())){p.setStatus("CONFIRMED");repo.save(p);}});}
}
