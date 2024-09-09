package com.itsqmet.Biblioteca.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Puede ser AUTO o IDENTITY, dependiendo de tu base de datos
    private Integer id;
    private String nombre;
    private Integer capacidad;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;
}
