package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Estudiante;
import com.itsqmet.Biblioteca.repositorios.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // READ
    @GetMapping("/estudiantes")
    public String estudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/estudiante";
    }

    // CREAR
    @GetMapping("/estudiante/form")
    public String formulario(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/formulario";
    }

    @PostMapping("/estudiante/form")
    public String crear(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return "redirect:/estudiantes";
    }

    // EDITAR
    @GetMapping("/estudiante/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student id:" + id));
        model.addAttribute("estudiante", estudiante);
        return "estudiante/formulario";
    }

    @PostMapping("/estudiante/editar/{id}")
    public String actualizar(@PathVariable int id, Estudiante estudiante) {
        estudiante.setIdEstudiante(id);
        estudianteRepository.save(estudiante);
        return "redirect:/estudiantes";
    }

    // ELIMINAR
    @GetMapping("/estudiante/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        estudianteRepository.deleteById(id);
        return "redirect:/estudiantes";
    }
}
