package com.procesos.demo.entity;

import com.procesos.demo.entity.emprendedor.AutoEvaluacion;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "procesoEmprendedor")
@Data
public class ProcesoEmprendedor {
    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;
    private String nombre;

    private AutoEvaluacion autoEvaluacion;

}
