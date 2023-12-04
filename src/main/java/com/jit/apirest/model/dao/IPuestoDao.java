package com.jit.apirest.model.dao;

import com.jit.apirest.model.entity.Puesto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IPuestoDao extends CrudRepository<Puesto, Integer> {
    @Query(value = "SELECT * FROM puesto WHERE nombre = :nombre LIMIT 1", nativeQuery = true)
    Puesto findByName(String nombre);
}
