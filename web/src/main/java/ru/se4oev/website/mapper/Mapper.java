package ru.se4oev.website.mapper;

import java.util.List;

/**
 * Created by karpenko on 02.12.2022.
 * Description:
 */
public interface Mapper<E, D> {

    public E toEntity(D dto);

    public D toDto(E entity);

    public List<E> toEntityList(Iterable<D> dtoList);

    public List<D> toDtoList(Iterable<E> entityList);

}
