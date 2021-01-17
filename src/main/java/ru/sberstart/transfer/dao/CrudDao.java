package ru.sberstart.transfer.dao;

import java.util.List;

public interface CrudDao<T, K> {
//    T findById(K id);
//    List<T> findAll();
    void create(T entity);
    T read(K id);
    void update(K id, T entity);
    void delete(K id);
}
