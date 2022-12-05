package ru.se4oev.web.service;

import ru.se4oev.web.data.Book;

import java.util.List;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public interface BookService {

    Book getBookById(Long id);

    List<Book> getAllBooks();

    void addBook(Book book);

    List<Book> findByAuthor(String author);

}
