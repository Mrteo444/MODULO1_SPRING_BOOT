package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Curso;
import com.itsqmet.Biblioteca.repositorios.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    // READ
    @GetMapping("/cursos")
    public String cursos(Model model) {
        List<Curso> cursos = cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "curso/curso";
    }

    // CREAR
    @GetMapping("/curso/form")
    public String formulario(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/formulario";
    }

    @PostMapping("/curso/form")
    public String crear(Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/cursos";
    }

    // EDITAR
    @GetMapping("/curso/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Curso curso = cursoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course id:" + id));
        model.addAttribute("curso", curso);
        return "curso/formulario";
    }

    // ELIMINAR
    @GetMapping("/curso/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        cursoRepository.deleteById(id);
        return "redirect:/cursos";
    }
}
