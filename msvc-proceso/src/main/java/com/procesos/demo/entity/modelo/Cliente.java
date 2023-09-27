package com.procesos.demo.entity.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.procesos.demo.enumeraciones.Etnia;
import com.procesos.demo.enumeraciones.Genero;
import com.procesos.demo.enumeraciones.NivelEstudio;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Cliente {

    private Long id;


    private String nombre;

    private String apellido;

    private Long dni;

    private Genero genero;

    private NivelEstudio nivelEstudio;

    private Etnia etnia;

    private Boolean victima;

    private Boolean discapacidad;

    private Boolean desplazamiento;


    private String telefono;

    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaNacimiento;

    private Municipio municipio;


    private String direccion;


    private String comentario;
    private Boolean activo;
    private String tipo;

    private Long usuario;

}
