package ru.se4oev.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.se4oev.web.data.Book;
import ru.se4oev.web.entity.BookEntity;
import ru.se4oev.web.exception.BookNotFoundException;
import ru.se4oev.web.mapper.BookMapper;
import ru.se4oev.web.repository.BookRepository;

import java.util.List;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found by id: " + id));
        return bookMapper.toDto(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        return bookMapper.toDtoList(iterable);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        Iterable<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        return bookMapper.toDtoList(iterable);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(bookMapper.toEntity(book));
    }

}
