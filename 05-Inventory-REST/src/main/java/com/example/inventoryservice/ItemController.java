package com.example.inventoryservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController public class ItemController {
 private static final Logger log=LoggerFactory.getLogger(ItemController.class);
 private final ItemService service;public ItemController(ItemService s){service=s;}
 @GetMapping("/items") public List<Item> list(){return service.list();}
 @GetMapping("/items/{id}") public Item get(@PathVariable Long id){return service.get(id);}
 @PostMapping("/items") @ResponseStatus(HttpStatus.CREATED) public Item add(@RequestBody Item i){log.info("Adding item {}",i.getName());return service.add(i);}
 public record ReduceRequest(int amount){}
 @PostMapping("/items/{id}/reduce") public Item reduce(@PathVariable Long id,@RequestBody ReduceRequest r){log.info("Reducing stock for item {} by {}",id,r.amount());return service.reduce(id,r.amount());}
}
