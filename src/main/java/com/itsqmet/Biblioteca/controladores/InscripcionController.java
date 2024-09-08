package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Inscripcion;
import com.itsqmet.Biblioteca.repositorios.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InscripcionController {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    // READ
    @GetMapping("/inscripciones")
    public String inscripciones(Model model) {
        List<Inscripcion> inscripciones = inscripcionRepository.findAll();
        model.addAttribute("inscripciones", inscripciones);
        return "inscripcion/inscripcion";
    }

    // CREAR
    @GetMapping("/inscripcion/form")
    public String formulario(Model model) {
        model.addAttribute("inscripcion", new Inscripcion());
        return "inscripcion/formulario";
    }

    @PostMapping("/inscripcion/form")
    public String crear(Inscripcion inscripcion) {
        inscripcionRepository.save(inscripcion);
        return "redirect:/inscripciones";
    }

    // ELIMINAR
    @GetMapping("/inscripcion/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        inscripcionRepository.deleteById(id);
        return "redirect:/inscripciones";
    }
}
