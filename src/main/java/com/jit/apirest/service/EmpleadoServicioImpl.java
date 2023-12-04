package com.jit.apirest.service;

import com.jit.apirest.model.dao.IEmpleadoDao;
import com.jit.apirest.model.entity.Empleado;
import com.jit.apirest.model.dto.EmpleadoDto;
import com.jit.apirest.service.mapper.EmpleadoDtoMapper;
import com.jit.apirest.service.mapper.EmpleadoEntityMapper;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicioImpl implements IEmpleadoServicio {
    private final IEmpleadoDao empleadoDao;
    private final EmpleadoDtoMapper dtoMapper;
    private final EmpleadoEntityMapper entityMapper;

    public EmpleadoServicioImpl(IEmpleadoDao empleadoDao,
                                EmpleadoDtoMapper dtoMapper,
                                EmpleadoEntityMapper entityMapper) {
        this.empleadoDao = empleadoDao;
        this.dtoMapper = dtoMapper;
        this.entityMapper = entityMapper;
    }

    @Transactional
    @Override
    public EmpleadoDto add(EmpleadoDto empleadoDto) {
        Optional<Empleado> empleado = Optional.of(entityMapper.apply(empleadoDto));
        empleado.ifPresent(this.empleadoDao::save);

        return empleado.map(dtoMapper).orElseThrow();
    }

    @Transactional
    @Override
    public EmpleadoDto update(EmpleadoDto empleadoDto) {
        Optional<Empleado> empleado = Optional.of(entityMapper.apply(empleadoDto));
        empleado.ifPresent(this.empleadoDao::save);

        return empleado.map(dtoMapper).orElseThrow();
    }

    @Transactional
    @Override
    public EmpleadoDto delete(Integer legajo) {
        if (empleadoDao.existsById(legajo)) {
            EmpleadoDto empleadoDto = this.getById(legajo);

            Empleado empleado = entityMapper.apply(empleadoDto);
            if (empleado != null) {
                this.empleadoDao.delete(empleado);

                return empleadoDto;
            }
        }

        throw new DataAccessResourceFailureException("La entidad de empleado resultante es nula");
    }

    @Transactional(readOnly = true)
    @Override
    public EmpleadoDto getById(Integer legajo) {
        Optional<Empleado> empleado = this.empleadoDao.findById(legajo);

        return empleado.map(dtoMapper).orElse(null);
    }

    public boolean existsById(Integer legajo) {
        return this.empleadoDao.existsById(legajo);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmpleadoDto> getAll() {
        List<Empleado> empleados = (List<Empleado>) this.empleadoDao.findAll();

        return empleados.stream().map(dtoMapper).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmpleadoDto> getByPuesto(int idPuesto) {
        List<Empleado> empleados = this.empleadoDao.findByPuesto(idPuesto);

        return empleados.stream().map(dtoMapper).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<EmpleadoDto> getByDepartamento(int idDepartamento) {
        List<Empleado> empleados = this.empleadoDao.findByDepartamento(idDepartamento);

        return empleados.stream().map(dtoMapper).toList();
    }
}
