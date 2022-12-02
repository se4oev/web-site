package ru.se4oev.auth.repository;

import org.springframework.data.repository.CrudRepository;
import ru.se4oev.auth.entity.ClientEntity;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public interface ClientRepository extends CrudRepository<ClientEntity, String> {

}
