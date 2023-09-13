package com.usuario.msvcusuario.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.usuario.msvcusuario.enumeraciones.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotNull
    private Long cedula;
    @NotBlank
    private String profesion;
    @NotBlank
    @Column(unique = true)
    private String telefono;
    @NotBlank
    @Column(unique = true)
    @Email(message = "El correo electrónico no es válido")
    private String email;
    @NotBlank
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "America/Bogota")
    private Timestamp regdate;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "America/Bogota")
    private Timestamp updatedate;

    private Boolean activo;

    @PrePersist
    public void active(){
        this.activo=true;

    }
}
