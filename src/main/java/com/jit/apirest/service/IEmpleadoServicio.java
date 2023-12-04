package com.jit.apirest.service;

import com.jit.apirest.model.dto.EmpleadoDto;

import java.util.List;

public interface IEmpleadoServicio extends Servicio<EmpleadoDto, Integer> {
    List<EmpleadoDto> getByPuesto(int idPuesto);

    List<EmpleadoDto> getByDepartamento(int idDepartamento);
}
