package com.procesos.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "procesoEmpresario")
public class ProcesoEmpresario {
    private Long id;
    private String nombre;
}
