package ru.se4oev.website.mapper;

import org.springframework.stereotype.Component;
import ru.se4oev.website.data.Book;
import ru.se4oev.website.data.BookRequest;

import java.util.List;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@Component
public class BookRequestMapper implements Mapper<Book, BookRequest> {

    @Override
    public Book toEntity(BookRequest dto) {
        return new Book(
                null,
                dto.getAuthor(),
                dto.getTitle(),
                dto.getPrice());
    }

    @Override
    public BookRequest toDto(Book entity) {
        return new BookRequest(
                entity.getAuthor(),
                entity.getTitle(),
                entity.getPrice());
    }

    @Override
    public List<Book> toEntityList(Iterable<BookRequest> dtoList) {
        throw new RuntimeException("Not implemented here!");
    }

    @Override
    public List<BookRequest> toDtoList(Iterable<Book> entityList) {
        throw new RuntimeException("Not implemented here!");
    }

}
