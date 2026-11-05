package com.example.bookservice;
import java.util.List;
import org.springframework.stereotype.Service;
@Service public class RecommendBooksByGenre {
 private final BookCatalog catalog;public RecommendBooksByGenre(BookCatalog catalog){this.catalog=catalog;}
 public List<Book> execute(String genre){if(genre==null||genre.isBlank())throw new IllegalArgumentException("genre required");return catalog.findByGenre(genre);}
}
