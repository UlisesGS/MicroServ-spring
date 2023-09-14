package com.cliente.msvccliente.MsvcUsuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
public class Usuario {


    private Long id;
    private String nombre;
    private String apellido;
    private Long cedula;
    private String profesion;
    private String telefono;
    private String email;
    private String password;
    private Role role;
    private Timestamp regdate;
    private Timestamp updatedate;
    private Boolean activo;
}
