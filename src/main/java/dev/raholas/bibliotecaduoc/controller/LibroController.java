package dev.raholas.bibliotecaduoc.controller;

import dev.raholas.bibliotecaduoc.model.Libro;
import dev.raholas.bibliotecaduoc.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }


    @PostMapping    // Aparentemente el @REquestBody es para pedir que nuestra variable
    // en este caso "libro" tenga los mismos atributos del objeto seleccionado en este caso "Libro"
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    //es importante el ("{id}") para evitar el amiggous mapping
    //es decir que para que se pueda distinguir entre los metodos
    @GetMapping ("{id}") //@PathVariable parece almacenar el
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping ("{id}")//put mapping parece ser una accion que tiene que realizar si al servidor
    //le llega una petición de tipo PUT
    //Request body creo que transforma lo que le envie a mi objeto "Libro"
    //@PathVariable hace que el id que enviemos mediante la url lo utilize
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro ){
        //el id se usara mas adelante
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){

        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }


}
