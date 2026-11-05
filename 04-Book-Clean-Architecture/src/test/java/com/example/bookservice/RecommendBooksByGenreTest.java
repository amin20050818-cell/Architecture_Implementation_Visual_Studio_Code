package com.example.bookservice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
class RecommendBooksByGenreTest {
 @Test void filtersGenre() {BookCatalog catalog=mock(BookCatalog.class);when(catalog.findByGenre("AI")).thenReturn(List.of(new Book("Deep Learning","AI")));var useCase=new RecommendBooksByGenre(catalog);assertEquals(1,useCase.execute("AI").size());verify(catalog).findByGenre("AI");}
 @Test void rejectsEmptyGenre(){assertThrows(IllegalArgumentException.class,()->new RecommendBooksByGenre(mock(BookCatalog.class)).execute(""));}
}
