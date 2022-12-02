package ru.se4oev.auth.service;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.se4oev.auth.entity.ClientEntity;
import ru.se4oev.auth.exception.LoginException;
import ru.se4oev.auth.exception.RegistrationException;
import ru.se4oev.auth.repository.ClientRepository;

import java.util.Optional;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
@Service
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public void register(String clientId, String clientSecret) {
        if (clientRepository.findById(clientId).isPresent())
            throw new RegistrationException("Client with id: " + clientId + " already registered");
        String hash = BCrypt.hashpw(clientSecret, BCrypt.gensalt());
        clientRepository.save(new ClientEntity(clientId, hash));
    }

    @Override
    public void checkCredentials(String clientId, String clientSecret) {
        Optional<ClientEntity> optionalClientEntity = clientRepository.findById(clientId);
        if (optionalClientEntity.isEmpty())
            throw new LoginException("Client with id: " + clientId + " not found");
        ClientEntity clientEntity = optionalClientEntity.get();

        if (!BCrypt.checkpw(clientSecret, clientEntity.getHash()))
            throw new LoginException("Secret is incorrect");
    }

}
