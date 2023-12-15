package com.proyecto.infinitTask.app.dtos.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTORequest {

    private String usuario;

    private String password;

    private String nombre;

    private String apellido;

    private String email;
}
