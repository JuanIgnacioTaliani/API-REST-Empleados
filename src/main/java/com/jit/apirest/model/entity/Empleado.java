package com.jit.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "legajo")
    private Integer legajo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_documento_id", referencedColumnName = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "nro_documento")
    private int nroDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero_calle")
    private int numeroCalle;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "localidad_id", referencedColumnName = "id_localidad")
    private Localidad localidad;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "fecha_contratacion")
    private Date fechaContratacion;

    @Column(name = "salario")
    private int salario;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "puesto_id", referencedColumnName = "id_puesto")
    private Puesto puesto;
}
