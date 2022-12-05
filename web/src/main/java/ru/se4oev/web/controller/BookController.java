package ru.se4oev.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.se4oev.web.data.Book;
import ru.se4oev.web.data.BookRequest;
import ru.se4oev.web.mapper.BookRequestMapper;
import ru.se4oev.web.service.BookService;

import java.util.List;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRequestMapper mapper;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author) {
        if (author != null)
            return bookService.findByAuthor(author);
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        bookService.addBook(mapper.toEntity(request));
    }

}
