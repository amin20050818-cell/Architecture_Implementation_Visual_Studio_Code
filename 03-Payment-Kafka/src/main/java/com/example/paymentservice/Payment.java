package com.example.paymentservice;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity public class Payment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private BigDecimal amount;private String status;
 public Long getId(){return id;}public BigDecimal getAmount(){return amount;}public void setAmount(BigDecimal a){amount=a;}public String getStatus(){return status;}public void setStatus(String s){status=s;}
}
