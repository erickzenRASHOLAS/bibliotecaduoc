package dev.raholas.bibliotecaduoc.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Prestamo {

    private int idPrestamo;
    private int idLibro;
    private String runSolicitante;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSolicitud;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEntrega;
    private int cantidadDias;
    private int multas=0;



}
