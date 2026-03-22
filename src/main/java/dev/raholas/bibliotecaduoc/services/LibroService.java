package dev.raholas.bibliotecaduoc.services;

import dev.raholas.bibliotecaduoc.model.Libro;
import dev.raholas.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LibroService {

    @Autowired

    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id){
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "! Libro ELIMINADO Con Éxito ¡";

    }

    public int totalLibros(){
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2(){
        return  libroRepository.totalLibros();
    }

    public Libro getLibroIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);

    }

    public List<Libro> getLibroYear(int anio){
        return libroRepository.buscarPorAnio(anio);
    }

    public List<Libro> getLibroAuthor(String autor){
        return libroRepository.buscarPorAutor(autor);
    }

    public Libro getLibroOldest(){
        return libroRepository.buscarMasAntiguo();
    }

    public Libro getLibroNewest(){
        return libroRepository.buscarMasNuevo();
    }

    public List<Libro> getLibroPublished(){
        return libroRepository.buscarOrdenPublicacion();
    }

}
