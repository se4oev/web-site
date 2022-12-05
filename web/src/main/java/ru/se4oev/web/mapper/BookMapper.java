package ru.se4oev.web.mapper;

import org.springframework.stereotype.Component;
import ru.se4oev.web.data.Book;
import ru.se4oev.web.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@Component
public class BookMapper implements Mapper<BookEntity, Book> {

    @Override
    public BookEntity toEntity(Book dto) {
        return new BookEntity(
                dto.getId(),
                dto.getAuthor(),
                dto.getTitle(),
                dto.getPrice());
    }

    @Override
    public Book toDto(BookEntity entity) {
        return new Book(
                entity.getId(),
                entity.getAuthor(),
                entity.getTitle(),
                entity.getPrice());
    }

    @Override
    public List<BookEntity> toEntityList(Iterable<Book> dtoList) {
        List<BookEntity> entityList = new ArrayList<>();
        for (Book book : dtoList)
            entityList.add(toEntity(book));
        return entityList;
    }

    @Override
    public List<Book> toDtoList(Iterable<BookEntity> entityList) {
        List<Book> dtoList = new ArrayList<>();
        for (BookEntity entity : entityList)
            dtoList.add(toDto(entity));
        return dtoList;
    }

}
