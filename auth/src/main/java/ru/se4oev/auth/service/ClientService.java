package ru.se4oev.auth.service;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public interface ClientService {

    void register(String clientId, String clientSecret);

    void checkCredentials(String clientId, String clientSecret);

}
