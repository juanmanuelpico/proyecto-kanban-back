package com.proyecto.infinitTask.app.dtos.response.Tarea;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TareaDTOResponse {

    private int id;

    private String titulo;

    private boolean activo;

    private String descripcion;

    private String dificultad;

    private String estado;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

}
