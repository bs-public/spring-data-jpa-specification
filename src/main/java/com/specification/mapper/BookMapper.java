package com.specification.mapper;

import com.specification.dto.BookDTO;
import com.specification.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

  @Mapping(source = "author", target = "author")
  BookDTO toBookDTO(Book book);
}
