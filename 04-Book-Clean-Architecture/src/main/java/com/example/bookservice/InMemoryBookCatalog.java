package com.example.bookservice;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository public class InMemoryBookCatalog implements BookCatalog {
 private final List<Book> books=List.of(new Book("Artificial Intelligence: A Modern Approach","AI"),new Book("Deep Learning","AI"),new Book("Clean Code","Software"),new Book("Domain-Driven Design","Software"));
 public List<Book> findByGenre(String genre){return books.stream().filter(b->b.genre().equalsIgnoreCase(genre)).toList();}
}
