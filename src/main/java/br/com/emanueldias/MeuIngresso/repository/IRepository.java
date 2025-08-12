package br.com.emanueldias.MeuIngresso.repository;

import java.sql.Connection;
import java.util.Set;

public interface IRepository <T>{
    Set<T> getAll();
    T findById(Long id);
    T save(T entity);
    T update(Long id, T entityUpdated);
    void deleteById(Long id);
}
