package com.procesos.demo.entity.emprendedor.canvas;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "recursos_claves")
@Data
public class RecursoClave {
    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;
    private String captacion;
    private String fidelizacion;

    private String estimulacion;

}
