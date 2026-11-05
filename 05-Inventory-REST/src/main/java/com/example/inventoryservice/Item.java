package com.example.inventoryservice;
import jakarta.persistence.*;
@Entity public class Item {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String name; private int quantity;
 public Long getId(){return id;}public String getName(){return name;}public void setName(String n){name=n;}public int getQuantity(){return quantity;}public void setQuantity(int q){quantity=q;}
}
