package com.procesos.demo.entity.emprendedor.canvas;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "relacion_clientes")
public class RelacionCliente {

    private String captacion;
    private String fidelizacion;
    private String estimuzacion;


}
