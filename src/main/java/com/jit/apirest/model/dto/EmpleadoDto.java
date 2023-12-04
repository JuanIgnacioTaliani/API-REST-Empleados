package com.jit.apirest.model.dto;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmpleadoDto {
    private Integer legajo;
    private String tipoDocumento;
    private int nroDocumento;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String calle;
    private int numeroCalle;
    private String localidad;
    private Date fechaNacimiento;
    private Date fechaContratacion;
    private int salario;
    private String puesto;
    private String departamento;
}
