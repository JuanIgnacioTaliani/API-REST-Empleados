package com.jit.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "localidad")
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad")
    private int idLocalidad;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "provincia_id", referencedColumnName = "id_provincia")
    private Provincia provincia;
}
