package com.procesos.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "procesoEmprendedor")
public class ProcesoEmprendedor {
    @Id
    private Long id;
    private String nombre;

}
