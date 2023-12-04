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
@Table(name = "tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private int idTipoDocumento;

    @Column(name = "nombre")
    private String nombre;
}
