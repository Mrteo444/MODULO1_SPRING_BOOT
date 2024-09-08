package com.itsqmet.Biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_docente;
    private String docente_nombre;
    private String docente_apellido;
    private String correo;
    private String especialidad; // Corregido aquí
}
