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
@Table(name = "puesto")
public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto")
    private int idPuesto;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id_departamento")
    private Departamento departamento;
}
