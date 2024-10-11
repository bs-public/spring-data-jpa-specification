package com.specification.controller;

import com.specification.dto.BookDTO;
import com.specification.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public List<BookDTO> searchBooks(
      @RequestParam(required = false) String title,
      @RequestParam(required = false) String author,
      @RequestParam(required = false) String language,
      @RequestParam(required = false) String genre,
      @RequestParam(required = false) String publisher,
      @RequestParam(required = false) String isbn) {
    return bookService.searchBooks(title, author, language, genre, publisher, isbn);
  }
}
