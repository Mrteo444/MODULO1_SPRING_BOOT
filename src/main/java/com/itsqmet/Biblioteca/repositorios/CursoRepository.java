package com.itsqmet.Biblioteca.repositorios;

import com.itsqmet.Biblioteca.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}