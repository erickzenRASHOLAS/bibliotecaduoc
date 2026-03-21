package dev.raholas.bibliotecaduoc.repository;

import dev.raholas.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

@Repository
public class LibroRepository {

    //Arreglo para guardar los libros
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository() {

        listaLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "AddisonWesley", 2008, "Joshua Bloch"));
        listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
        listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "AddisonWesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));


    }

    //Metodo para retornar los libros
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros){
            if ( libro.getId()==id ){
                return libro;
            }
        }
        return null;
    }


    //Buscar por isbnm
    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : listaLibros){
            if ( libro.getIsbn().equals(isbn) ){
                return libro;
            }
        }
        return null;
    }

    //guarda y retorna le libro
    public Libro guardar(Libro libr){
        listaLibros.add(libr);
        return libr;

    }

    //Acutaliza libro (seria un put, porque, cambiaTodo)

    public Libro actualizar(Libro libr){
        int id =0;
        int idPosicion=0;

        for (int i = 0; i < listaLibros.size(); i++) {
           if( listaLibros.get(i).getId() == libr.getId() ) {
               id = libr.getId();
               idPosicion = i;
           }

        }

        Libro libro1=new Libro();
        libro1.setId(id);
        libro1.setIsbn(libr.getIsbn() );
        libro1.setTitulo(libr.getTitulo() );
        libro1.setEditorial(libr.getEditorial() );
        libro1.setFechaPublicacion(libr.getFechaPublicacion() );
        libro1.setAutor(libr.getAutor() );

        listaLibros.set(idPosicion, libro1);
        return libro1;

    }

    //metodos para eliminar libros
    public void eliminar(int id){

        //alternativa 1
        Libro libro= buscarPorId(id);

        if(libro!=null){
            listaLibros.remove(libro);

        }

        /*
        // alternativa 2
        int idPoscicion=0;
        for (int i =  0; i < listaLibros.size(); i++) {
            if(listaLibros.get(i).getId()==id){
                idPoscicion=i;
                break;

            }
        }

        if(idPoscicion>0){
            listaLibros.remove(idPoscicion);
        }


        //otra alternativa
        listaLibros.removeIf(x -> x.getId()==id ); */


    }

    public int totalLibros(){
        return listaLibros.size();
    }


    public List<Libro> buscarPorAnio(int anio){
        List<Libro> listaAnioLibro = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion()==anio){
                listaAnioLibro.add(libro);
            }
        }
        return listaAnioLibro;

    }

    public List<Libro> buscarPorAutor(String autor){
        List<Libro> listaAutorLibro = new ArrayList<>();
        for (Libro libro : listaLibros) {
            //el replace va en los 2 lados para que separe tanto lo de la base de datos como lo que introduce el usuario
            if(libro.getAutor().replace(" ","").equalsIgnoreCase(autor.replace(" ","")) ){
                listaAutorLibro.add(libro);
            }
        }
        return listaAutorLibro;
    }


}
