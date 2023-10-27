package com.cliente.msvccliente.entity;


import com.cliente.msvccliente.enumeraciones.Etnia;
import com.cliente.msvccliente.enumeraciones.Genero;
import com.cliente.msvccliente.enumeraciones.NivelEstudio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotNull
    @Column(unique = true)
    private Long dni;
    @Enumerated(value = EnumType.STRING)
    private Genero genero;
    @Enumerated(value = EnumType.STRING)
    private NivelEstudio nivelEstudio;
    @Enumerated(value = EnumType.STRING)
    private Etnia etnia;
    @NotNull
    private Boolean victima;
    @NotNull
    private Boolean discapacidad;
    @NotNull
    private Boolean desplazamiento;
    @NotBlank
    @Column(unique = true)
    private String telefono;
    @NotBlank
    @Column(unique = true)
    private String email;


    @Temporal(TemporalType.DATE)

    private Date fechaNacimiento;

    @Enumerated(value = EnumType.STRING)
    @ManyToOne
    @JoinColumn(name = "id_municipio", unique = false)
    private Municipio municipio;

    @NotBlank
    private String direccion;

    @Lob
    @Column(length = 2500)
    private String comentario;
    private Boolean activo;
    private String tipo;

    private Long usuario;


}
