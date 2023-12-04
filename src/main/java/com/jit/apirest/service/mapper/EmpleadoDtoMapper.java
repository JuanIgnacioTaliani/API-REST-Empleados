package com.jit.apirest.service.mapper;

import com.jit.apirest.model.entity.*;
import com.jit.apirest.model.dto.EmpleadoDto;
import org.springframework.stereotype.Service;
import java.util.function.Function;

@Service
public class EmpleadoDtoMapper implements Function<Empleado, EmpleadoDto> {
    @Override
    public EmpleadoDto apply(Empleado empleado) {
        TipoDocumento tipoDoc = empleado.getTipoDocumento();
        Localidad localidad = empleado.getLocalidad();
        Puesto puesto = empleado.getPuesto();
        Departamento departamento = puesto.getDepartamento();
        return new EmpleadoDto(empleado.getLegajo(),
                tipoDoc.getNombre(),
                empleado.getNroDocumento(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getEmail(),
                empleado.getTelefono(),
                empleado.getCalle(),
                empleado.getNumeroCalle(),
                localidad.getNombre(),
                empleado.getFechaNacimiento(),
                empleado.getFechaContratacion(),
                empleado.getSalario(),
                puesto.getNombre(),
                departamento.getNombre());
    }
}
