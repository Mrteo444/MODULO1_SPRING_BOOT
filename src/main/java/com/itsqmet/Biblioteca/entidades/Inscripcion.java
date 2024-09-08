package com.itsqmet.Biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Inscripcion {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id_inscripcion ;
    private  int id_estudiante;
    private  int id_curso;
    private  String datos_inscripcion;


}
