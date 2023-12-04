package com.jit.apirest.model.dao;

import com.jit.apirest.model.entity.TipoDocumento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITipoDocumentoDao extends CrudRepository<TipoDocumento, Integer> {
    @Query(value = "SELECT * FROM tipo_documento WHERE nombre = :nombre LIMIT 1", nativeQuery = true)
    TipoDocumento findByName(String nombre);
}
