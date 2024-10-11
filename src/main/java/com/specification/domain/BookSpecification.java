package com.specification.domain;

import com.specification.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

  public static Specification<Book> hasTitle(String title) {
    return (root, query, criteriaBuilder) ->
        title == null
            ? criteriaBuilder.conjunction()
            : criteriaBuilder.equal(root.get("title"), title);
  }

  public static Specification<Book> hasAuthor(String author) {
    return (root, query, criteriaBuilder) -> {
      if (author == null) {
        return criteriaBuilder.conjunction();
      } else {
        return criteriaBuilder.or(
            criteriaBuilder.equal(root.get("author").get("firstName"), author),
            criteriaBuilder.equal(root.get("author").get("lastName"), author),
            criteriaBuilder.equal(
                criteriaBuilder.concat(
                    criteriaBuilder.concat(root.get("author").get("firstName"), " "),
                    root.get("author").get("lastName")),
                author));
      }
    };
  }

  public static Specification<Book> hasLanguage(String language) {
    return (root, query, criteriaBuilder) ->
        language == null
            ? criteriaBuilder.conjunction()
            : criteriaBuilder.equal(root.get("language"), language);
  }

  public static Specification<Book> hasGenre(String genre) {
    return (root, query, criteriaBuilder) ->
        genre == null
            ? criteriaBuilder.conjunction()
            : criteriaBuilder.equal(root.get("genre"), genre);
  }

  public static Specification<Book> hasPublisher(String publisher) {
    return (root, query, criteriaBuilder) ->
        publisher == null
            ? criteriaBuilder.conjunction()
            : criteriaBuilder.equal(root.get("publisher"), publisher);
  }

  public static Specification<Book> hasIsbn(String isbn) {
    return (root, query, criteriaBuilder) ->
        isbn == null
            ? criteriaBuilder.conjunction()
            : criteriaBuilder.equal(root.get("isbn"), isbn);
  }
}
