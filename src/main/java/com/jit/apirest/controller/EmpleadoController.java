package com.jit.apirest.controller;

import com.jit.apirest.model.dto.EmpleadoDto;
import com.jit.apirest.model.payload.MensajeResponse;
import com.jit.apirest.service.IEmpleadoServicio;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {
    private final IEmpleadoServicio empleadoServicio;

    public EmpleadoController(IEmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    @PostMapping("empleado")
    public ResponseEntity<?> add(@RequestBody EmpleadoDto empleado) {
        try {
            EmpleadoDto empleadoCreate = this.empleadoServicio.add(empleado);
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje("Guardado correctamente")
                            .objeto(empleadoCreate)
                            .build()
                    , HttpStatus.CREATED
            );
        } catch (DataAccessException exDt) {
            exDt.printStackTrace();
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }

    @PutMapping("empleado/{legajo}")
    public ResponseEntity<?> update(@RequestBody EmpleadoDto empleado, @PathVariable Integer legajo) {
        try {
            if (this.empleadoServicio.existsById(legajo)) {
                empleado.setLegajo(legajo);
                EmpleadoDto empleadoUpdate = this.empleadoServicio.update(empleado);
                return new ResponseEntity<>(
                        MensajeResponse
                                .builder()
                                .mensaje("Modificado correctamente")
                                .objeto(empleadoUpdate)
                                .build()
                        , HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        MensajeResponse
                                .builder()
                                .mensaje("No existe el registro de legajo " + empleado.getLegajo())
                                .objeto(null)
                                .build()
                        , HttpStatus.NOT_FOUND
                );
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }

    @DeleteMapping("empleado/{legajo}")
    public ResponseEntity<?> delete(@PathVariable Integer legajo) {
        try {
            EmpleadoDto empleadoDelete = this.empleadoServicio.delete(legajo);
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje("Eliminado correctamente")
                            .objeto(empleadoDelete)
                            .build()
                    , HttpStatus.OK
            );
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }

    @GetMapping("empleado/{legajo}")
    public ResponseEntity<?> getById(@PathVariable Integer legajo) {
        EmpleadoDto empleado = empleadoServicio.getById(legajo);
        if (empleado != null) {
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje("")
                            .objeto(empleado)
                            .build()
                    , HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje("No existe el registro de legajo " + legajo)
                            .objeto(null)
                            .build()
                    , HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("empleados")
    public ResponseEntity<?> getAll() {
        try {
            List<EmpleadoDto> empleados = this.empleadoServicio.getAll();
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje("")
                            .objeto(empleados)
                            .build()
                    , HttpStatus.OK
            );
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build()
                    , HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("empleados/puestos/{idPuesto}")
    public ResponseEntity<?> getByPuesto(@PathVariable Integer idPuesto) {
        try {
            List<EmpleadoDto> empleados = this.empleadoServicio.getByPuesto(idPuesto);
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje("")
                            .objeto(empleados)
                            .build()
                    , HttpStatus.OK
            );
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build()
                    , HttpStatus.NOT_FOUND
            );
        }
    }

    @GetMapping("empleados/departamentos/{idDepartamento}")
    public ResponseEntity<?> getByDepartamento(@PathVariable Integer idDepartamento) {
        try {
            List<EmpleadoDto> empleados = this.empleadoServicio.getByDepartamento(idDepartamento);
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje("")
                            .objeto(empleados)
                            .build()
                    , HttpStatus.OK
            );
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse
                            .builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build()
                    , HttpStatus.NOT_FOUND
            );
        }
    }
}
