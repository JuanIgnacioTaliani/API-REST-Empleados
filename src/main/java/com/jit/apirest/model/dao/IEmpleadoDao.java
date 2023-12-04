package com.jit.apirest.model.dao;

import com.jit.apirest.model.entity.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEmpleadoDao extends CrudRepository<Empleado, Integer> {
    @Query(value = "SELECT e.* " +
            "FROM empleados e " +
            "JOIN puesto p ON e.puesto_id = p.id_puesto " +
            "JOIN departamento d ON p.departamento_id = d.id_departamento " +
            "WHERE p.id_puesto = :idPuesto", nativeQuery = true)
    List<Empleado> findByPuesto(int idPuesto);

    @Query(value = "SELECT e.* " +
            "FROM empleados e " +
            "JOIN puesto p ON e.puesto_id = p.id_puesto " +
            "JOIN departamento d ON p.departamento_id = d.id_departamento " +
            "WHERE d.id_departamento = :idDepartamento", nativeQuery = true)
    List<Empleado> findByDepartamento(int idDepartamento);
}
