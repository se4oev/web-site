package ru.se4oev.auth.exception;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public class LoginException extends RuntimeException {

    public LoginException(String message) {
        super(message);
    }

}
