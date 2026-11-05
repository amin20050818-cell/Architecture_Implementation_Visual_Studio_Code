package com.example.paymentservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
@RestController @RequestMapping("/api/payments") public class PaymentController {
 private final PaymentRepository repo;private final PaymentEventProducer producer;
 public PaymentController(PaymentRepository r,PaymentEventProducer p){repo=r;producer=p;}
 public record CreatePayment(BigDecimal amount){}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Payment create(@RequestBody CreatePayment input){if(input.amount()==null||input.amount().signum()<=0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Positive amount required");Payment p=new Payment();p.setAmount(input.amount());p.setStatus("PENDING");Payment saved=repo.save(p);producer.publish(saved.getId());return saved;}
 @GetMapping("/{id}") public Payment get(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Payment not found"));}
}
