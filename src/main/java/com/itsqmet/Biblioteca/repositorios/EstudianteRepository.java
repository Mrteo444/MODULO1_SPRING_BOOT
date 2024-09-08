package com.itsqmet.Biblioteca.repositorios;

import com.itsqmet.Biblioteca.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
