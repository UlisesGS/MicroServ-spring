package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "socios_claves")
@Data
public class SocioCLave {

    private String proveedores;
    private String entidadesPublicas;
    private String entidadesPrivadas;
    private String academias;
    private String otros;

}
