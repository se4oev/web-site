package ru.se4oev.web.repository;

import org.springframework.data.repository.CrudRepository;
import ru.se4oev.web.entity.BookEntity;

import java.util.List;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAllByAuthorContaining(String author);

}
