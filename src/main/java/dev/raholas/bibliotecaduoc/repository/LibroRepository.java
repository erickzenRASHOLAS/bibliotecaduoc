package dev.raholas.bibliotecaduoc.repository;


import dev.raholas.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import dev.raholas.bibliotecaduoc.model.Libro;
import java.util.ArrayList;
import java.util.List;


@Repository

public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerLibros(){
        return  listaLibros;
    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros){
            if(Libro.getId()== id ){
                return libro;
            }
        }
        return null;
    }


    public Libro acutalizar(Libro)






}
