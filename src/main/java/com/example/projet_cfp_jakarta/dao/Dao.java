package com.example.projet_cfp_jakarta.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(Long id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    boolean delete(Long id);
}
