package com.example.inventoryservice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service public class ItemService {
 private final ItemRepository repo; public ItemService(ItemRepository repo){this.repo=repo;}
 public List<Item> list(){return repo.findAll();}
 public Item get(Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Item not found"));}
 public Item add(Item item){if(item.getQuantity()<0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Negative quantity");return repo.save(item);}
 @Transactional public Item reduce(Long id,int amount){if(amount<=0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Reduction must be positive");Item i=get(id);if(i.getQuantity()<amount)throw new ResponseStatusException(HttpStatus.CONFLICT,"Insufficient stock");i.setQuantity(i.getQuantity()-amount);return repo.save(i);}
}
