package dev.raholas.bibliotecaduoc.repository;

import dev.raholas.bibliotecaduoc.model.Prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {
    private List<Prestamo> listaPrestamos = new ArrayList<>();

    /// metodo para obtener los prestamos
    public List<Prestamo> obtenerPrestamos() {
        return listaPrestamos;
    }

    /// Buscar por id del prestamo
    public Prestamo buscarPrestamoId(int id ){
        for (Prestamo prestamo: listaPrestamos){
            if(prestamo.getIdPrestamo()==id){
                return prestamo;
            }
        }
        return null;
    }

    /// Buscar por id del libro
    /// Utilizamos una lista porque un libro puede estar en varios prestamos
    public List<Prestamo> buscarPrestamoIdLibro(int id){
        List<Prestamo> listaPrestamoIdLibro = new ArrayList<>();
        for(Prestamo prestamo: listaPrestamos){
            if(prestamo.getIdLibro()==id){
                listaPrestamoIdLibro.add(prestamo);
            }
        }
        return listaPrestamoIdLibro;
    }


    /// Buscar por Run
    /// Encontre este codigo en internet
    // el ^ indica que (T)ODO lo que NO Este en los corchetes sera reemplazado
    ///  no se puede poner "tod o" junto
    public List<Prestamo> buscarPrestamoRun(String run){
        List<Prestamo> listaPrestamoRun = new ArrayList<>();
        String runEntrante=run.replaceAll("[^0-9kK]","");
        for(Prestamo prestamo: listaPrestamos){
            if(prestamo.getRunSolicitante().replaceAll("[^0-9kK]","").equalsIgnoreCase(runEntrante) ){
                listaPrestamoRun.add(prestamo);
            }
        }
        return listaPrestamoRun;
    }

    public Prestamo guardarPrestamo(Prestamo prest){
        listaPrestamos.add(prest);
        return prest;
    }

    public Prestamo actualizarPrestamo(Prestamo prest){
        int id=0;
        int idPosicion=0;

        for (int i = 0; i < listaPrestamos.size(); i++) {
            if(prest.getIdPrestamo() == listaPrestamos.get(i).getIdPrestamo() ){
                id=prest.getIdPrestamo();
                idPosicion=i;
            }
        }
        Prestamo prestamoN= new Prestamo();
        prestamoN.setIdPrestamo(id);
        prestamoN.setIdLibro(prest.getIdLibro());
        prestamoN.setRunSolicitante(prest.getRunSolicitante());
        prestamoN.setFechaSolicitud(prest.getFechaSolicitud());
        prestamoN.setFechaEntrega(prest.getFechaEntrega());
        prestamoN.setCantidadDias(prest.getCantidadDias());
        prestamoN.setMultas(prest.getMultas());

        listaPrestamos.set(idPosicion, prestamoN);
        return prestamoN;

    }


}
