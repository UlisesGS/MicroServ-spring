package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "propuesta_valor")
@Data
public class PropuestaValor {
    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;
    private String proposicion;

}
