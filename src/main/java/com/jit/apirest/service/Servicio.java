package com.jit.apirest.service;

import java.util.List;

public interface Servicio<T, ID> {
    T add(T entity);
    T update(T entity);
    T delete(ID id);
    T getById(ID id);
    boolean existsById(ID id);
    List<T> getAll();
}
