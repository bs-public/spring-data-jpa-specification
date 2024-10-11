package com.specification.service;

import com.specification.domain.BookSpecification;
import com.specification.dto.BookDTO;
import com.specification.entity.Book;
import com.specification.mapper.BookMapper;
import com.specification.repository.BookRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  BookService(BookRepository bookRepository, BookMapper bookMapper) {
    this.bookRepository = bookRepository;
    this.bookMapper = bookMapper;
  }

  public List<BookDTO> searchBooks(
      String title, String author, String language, String genre, String publisher, String isbn) {
    Specification<Book> spec =
        Specification.where(BookSpecification.hasTitle(title))
            .and(BookSpecification.hasAuthor(author))
            .and(BookSpecification.hasLanguage(language))
            .and(BookSpecification.hasGenre(genre))
            .and(BookSpecification.hasPublisher(publisher))
            .and(BookSpecification.hasIsbn(isbn));

    List<Book> books = bookRepository.findAll(spec);

    return books.stream().map(bookMapper::toBookDTO).collect(Collectors.toList());
  }
}
