package com.cliente.msvccliente.entity;

import com.cliente.msvccliente.MsvcUsuario.Usuario;
import com.cliente.msvccliente.enumeraciones.Etnia;
import com.cliente.msvccliente.enumeraciones.Genero;
import com.cliente.msvccliente.enumeraciones.NivelEstudio;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.catalina.User;
import org.aspectj.weaver.ast.Var;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
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

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaNacimiento;

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
