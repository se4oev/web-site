package ru.se4oev.website.exception;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }

}
