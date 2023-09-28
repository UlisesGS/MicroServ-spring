package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "actividades_claves")
@Data
public class ActividadClave {
    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;
    private String actividadPricipal;
    private String comunicacionMarketing;
    private String postVenta;
    private String otros;
}
