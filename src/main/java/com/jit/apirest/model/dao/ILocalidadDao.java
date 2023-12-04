package com.jit.apirest.model.dao;

import com.jit.apirest.model.entity.Localidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ILocalidadDao extends CrudRepository<Localidad, Integer> {
    @Query(value = "SELECT * FROM localidad WHERE nombre = :nombre LIMIT 1", nativeQuery = true)
    Localidad findByName(String nombre);
}
