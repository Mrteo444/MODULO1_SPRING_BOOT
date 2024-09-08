package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Docente;
import com.itsqmet.Biblioteca.repositorios.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class DocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    // READ
    @GetMapping("/docentes")
    public String docentes(Model model) {
        List<Docente> docentes = docenteRepository.findAll();
        model.addAttribute("docentes", docentes);
        return "docente/docente";
    }

    // CREAR
    @GetMapping("/docente/form")
    public String formulario(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente/formulario";
    }

    @PostMapping("/docente/form")
    public String crear(@ModelAttribute Docente docente) {
        docenteRepository.save(docente);
        return "redirect:/docentes";
    }

    // EDITAR
    @GetMapping("/docente/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid docent id:" + id));
        model.addAttribute("docente", docente);
        return "docente/formulario";
    }

    @PostMapping("/docente/editar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Docente docente) {
        docente.setId_docente(id);
        docenteRepository.save(docente);
        return "redirect:/docentes";
    }

    // ELIMINAR
    @GetMapping("/docente/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        docenteRepository.deleteById(id);
        return "redirect:/docentes";
    }
}
