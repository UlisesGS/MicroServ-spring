package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "flujo_ingresos")
@Data
public class FlujoDeIngreso {
    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;
    private String capitalPropio;
    private String capitalPrestamo;
    private String canalesPago;
    private String otros;


}
