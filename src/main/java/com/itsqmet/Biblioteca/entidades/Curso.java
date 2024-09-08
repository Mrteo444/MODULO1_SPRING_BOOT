package com.itsqmet.Biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Curso  {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer idCurso;
    private String cursoNombre;
    private  String descripcion;
    private  String creditos;

}
