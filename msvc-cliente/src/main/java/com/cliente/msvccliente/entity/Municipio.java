package com.cliente.msvccliente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Municipio {

    @Id
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String ciudad;
}
