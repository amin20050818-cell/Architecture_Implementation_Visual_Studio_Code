package com.example.bookservice;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController public class BookController {
 private final RecommendBooksByGenre useCase;public BookController(RecommendBooksByGenre u){useCase=u;}
 @GetMapping("/recommend") public List<Book> recommend(@RequestParam String genre){return useCase.execute(genre);}
}
