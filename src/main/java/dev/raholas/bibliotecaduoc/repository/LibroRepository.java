package dev.raholas.bibliotecaduoc.repository;

import dev.raholas.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    //Arreglo para guardar los libros
    private List<Libro> listaLibros = new ArrayList<>();


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


}
