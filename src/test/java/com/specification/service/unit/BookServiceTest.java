package com.specification.service.unit;

import com.specification.dto.BookDTO;
import com.specification.entity.Book;
import com.specification.mapper.BookMapper;
import com.specification.repository.BookRepository;
import com.specification.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

  @Mock private BookRepository bookRepository;

  @Mock private BookMapper bookMapper;

  @InjectMocks private BookService bookService;

  @Test
  void testSearchBooks_withNoCriteria() {
    // Arrange -> Act -> Assert
    when(bookRepository.findAll(any(Specification.class))).thenReturn(Collections.emptyList());

    List<BookDTO> bookDtos = bookService.searchBooks(null, null, null, null, null, null);

    assertTrue(bookDtos.isEmpty());
    verify(bookRepository).findAll(any(Specification.class));
  }

  @Test
  void testSearchBooks_withLanguageAndGenre() {
    String language = "English";
    String genre = "Adventure";

    Book book = new Book();
    book.setLanguage(language);
    book.setGenre(genre);

    BookDTO bookDTO = new BookDTO();
    bookDTO.setLanguage(language);
    bookDTO.setGenre(genre);

    List<Book> books = Collections.singletonList(book);
    List<BookDTO> expectedDtos = Collections.singletonList(bookDTO);

    when(bookRepository.findAll(any(Specification.class))).thenReturn(books);
    when(bookMapper.toBookDTO(book)).thenReturn(bookDTO);

    List<BookDTO> actualDtos = bookService.searchBooks(null, null, language, genre, null, null);

    assertEquals(expectedDtos, actualDtos);

    verify(bookRepository).findAll(any(Specification.class));
    verify(bookMapper).toBookDTO(book);
  }
}
