package dev.raholas.bibliotecaduoc.services;

import dev.raholas.bibliotecaduoc.model.Libro;
import dev.raholas.bibliotecaduoc.model.Prestamo;
import dev.raholas.bibliotecaduoc.repository.LibroRepository;
import dev.raholas.bibliotecaduoc.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {
    @Autowired

    public PrestamoRepository prestamoRepository;
    @Autowired
    private LibroRepository libroRepository;

    public List<Prestamo> getPrestamo(){
        return prestamoRepository.obtenerPrestamos();
    }

    public Prestamo getPrestamoId(int id){
        return prestamoRepository.buscarPrestamoId(id);
    }

    public List<Prestamo> getPrestamoIdLibro(int id){
        return prestamoRepository.buscarPrestamoIdLibro(id);
    }

    public List<Prestamo> getPrestamoRun(String run){
        return prestamoRepository.buscarPrestamoRun(run);
    }
    ///var libro= libroRepository.buscarPorId(prestamo.getIdLibro());
    /// var es para que se detecte de forma automatica la variable según entendi
    /// usamos el metodo del repositorio de libros y le decimos que busque
    /// usando el idLibro del objeto prestamo
    public  Prestamo savePrestamo(Prestamo prestamo){
        var libro= libroRepository.buscarPorId(prestamo.getIdLibro());
        /// Si el Libro existe lo agregamos, no es necesario validar su id
        /// ya que, no se agregaran libros si es que no tienen id
        if(libro != null){
            return prestamoRepository.guardarPrestamo(prestamo);
        }else {
            /// throw hace que se detenga para enviar el mensaje
            /// Ya que el metodo pide si o si un objeto Prestamo
            /// Pude simplemente retornar null pero quize probar esta opción
            throw new RuntimeException("!!! Error ¡¡¡ El libro con ID " + prestamo.getIdLibro() + " no existe.");
        }
    }

    public Prestamo updatePrestamo(Prestamo prestamo){
        var libro= libroRepository.buscarPorId(prestamo.getIdLibro());
        if(libro != null){
            return prestamoRepository.actualizarPrestamo(prestamo);
        }else{
            throw new RuntimeException("¡¡¡ ERROR !!! El idLibro: "+ prestamo.getIdLibro() +" de la actualización al prestamo NO existe");
        }

    }

    public String deletePrestamo(int id){
        prestamoRepository.eliminarPrestamo(id);
        return "¡¡ Prestamo ELIMINADO con ÉXITO";
    }



}
