package com.cliente.msvccliente.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Emprendedor extends Cliente{

    private String ideaNegocio;

    private String producto;
}
