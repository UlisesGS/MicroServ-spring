package com.procesos.demo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "procesoEmpresario")
@Data
public class ProcesoEmpresario {

    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;
    private String nombre;
}
