package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Autor;
import com.itsqmet.Biblioteca.entidades.Libro;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import com.itsqmet.Biblioteca.repositorios.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    AutorRepository autorRepository;

    //READ
    @GetMapping("/libros")
    public String libro(Model model) {

        List<Libro> libros = libroRepository.findAll();
        model.addAttribute("libros", libros);

        return "libro/libro";
    }

    // CREAR
    @GetMapping("/libro/form")
    public String formulario(Model model){
        model.addAttribute("libro", new Libro());


        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);

        return "libro/formulario";
    }

    @PostMapping("/libro/form")
    public String crear( Libro libro){
        libroRepository.save(libro);
        return "redirect:/libros";
    }



    //Eliminar
    @GetMapping("/libro/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        libroRepository.deleteById(id);
        return "redirect:/libros";
    }




}
