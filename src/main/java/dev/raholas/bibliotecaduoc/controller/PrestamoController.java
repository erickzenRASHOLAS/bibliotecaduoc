package dev.raholas.bibliotecaduoc.controller;

import dev.raholas.bibliotecaduoc.model.Prestamo;
import dev.raholas.bibliotecaduoc.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    /// agregar @RequestBody para exigir que el json a introducir
    /// tenga la misma estructura que el objeto Prestamo
    @PostMapping
    private Prestamo agregarPrestamo(@RequestBody Prestamo prestamo){
        return prestamoService.savePrestamo(prestamo);
    }

    @GetMapping
    private List<Prestamo> listarPrestamos(){
        return prestamoService.getPrestamo();
    }

    @GetMapping("{id}")
    private Prestamo buscarPrestamoId(@PathVariable int id){
        return prestamoService.getPrestamoId(id);
    }




}
