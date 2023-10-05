package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "componente_costo")
@Data
public class ComponenteCosto {
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String nombre;
    private double monto;
}
