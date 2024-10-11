package com.specification.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {
  private String title;
  private AuthorDTO author;
  private LocalDate publishedDate;
  private String isbn;
  private Integer pages;
  private String language;
  private String publisher;
  private String genre;
}
