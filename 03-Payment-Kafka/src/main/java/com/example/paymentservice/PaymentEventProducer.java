package com.example.paymentservice;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service public class PaymentEventProducer {
 private final KafkaTemplate<String,String> kafka;public PaymentEventProducer(KafkaTemplate<String,String> kafka){this.kafka=kafka;}
 public void publish(Long id){kafka.send("payment-created",id.toString());}
}
