package com.itsqmet.Biblioteca.controladores;

import com.itsqmet.Biblioteca.entidades.Autor;
import com.itsqmet.Biblioteca.repositorios.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
public class AutorControler {

    @Autowired
    AutorRepository autorRepository;


    // READ
    @GetMapping("/autores")
    public String autor(Model model){

        List<Autor> autores = autorRepository.findAll();
        model.addAttribute("autores", autores);

        return "/autor/autor";
    }

    // CREAR
    @GetMapping("/autor/form")
    public String formulario(Model model){
        model.addAttribute("autor", new Autor());

        return "/autor/formulario";
    }

    @PostMapping("/autor/form")
    public String crear( Autor autor){
       autorRepository.save(autor);
        return "redirect:/autores";
    }

    /////ACTUALIZAR
    @GetMapping("/autor/editar/{id}")
    public String actualizar(@PathVariable int id, Model model){

        Optional<Autor> autor = autorRepository.findById(id);
        model.addAttribute("autor", autor);

        return "autor/formulario";
    }


    //Eliminar
    @GetMapping("/autor/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        autorRepository.deleteById(id);

        return "redirect:/autores";

    }






    /////////////// CREACIÓN DE SERVICIOS /////////////
/*
     ///// GET
    @GetMapping("/autores")
    public List <Autor> autores(){
      //  List <Autor> autores = autorRepository.findAll();
        return autorRepository.findAll();
    }


    //// POST
    @PostMapping("/autores")
    public Autor crear(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }

    //////  DELETE
    @DeleteMapping("/autores/{id}")
    public ResponseEntity<Boolean> eliminarAutor(@PathVariable int id){
        Optional <Autor> autor = autorRepository.findById(id);
        autorRepository.delete(autor.get());
        return ResponseEntity.ok(true);
    }

    /////// PUT
    @PutMapping("/autores/{id}")
    public  ResponseEntity <Autor> actualizarAutor(@PathVariable int id, @RequestBody Autor autorData){
        Optional <Autor> opcionalAutor = autorRepository.findById(id);

        Autor autor = opcionalAutor.get();
        //actualizar
        autor.setNombre( autorData.getNombre() );
        autor.setApellido( autorData.getApellido());
        autor.setEmail( autorData.getEmail());

        Autor actorGuardado = autorRepository.save(autor);
        return ResponseEntity.ok(actorGuardado);

    }

*/

}
