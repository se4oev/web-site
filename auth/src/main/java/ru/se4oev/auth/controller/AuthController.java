package ru.se4oev.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.se4oev.auth.data.ErrorResponse;
import ru.se4oev.auth.data.TokenResponse;
import ru.se4oev.auth.data.User;
import ru.se4oev.auth.exception.LoginException;
import ru.se4oev.auth.exception.RegistrationException;
import ru.se4oev.auth.service.ClientService;
import ru.se4oev.auth.service.TokenService;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ClientService clientService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> registre(@RequestBody User user) {
        clientService.register(user.getClientId(), user.getClientSecret());
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody User user) {
        clientService.checkCredentials(user.getClientId(), user.getClientSecret());
        return new TokenResponse(tokenService.generateToken(user.getClientId()));
    }

    @ExceptionHandler({RegistrationException.class, LoginException.class})
    public ResponseEntity<ErrorResponse> handleUserRegistrationException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
    }

}
