package ru.se4oev.auth.service;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public interface TokenService {

    String generateToken(String clientId);

}
