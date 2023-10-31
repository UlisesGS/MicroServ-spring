package com.procesos.demo.entity;

import com.procesos.demo.entity.emprendedor.AutoEvaluacion;
import com.procesos.demo.entity.emprendedor.canvas.Canvas;
import com.procesos.demo.entity.emprendedor.modelobasico.PlanNegocio;
import com.procesos.demo.entity.emprendedor.modelofinanciero.PlanFinanciero;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "procesoEmprendedor")
@Data
public class ProcesoEmprendedor {
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String nombre;

    private AutoEvaluacion autoEvaluacion;
    private PlanNegocio planNegocio;
    private Canvas canvas;
    private PlanFinanciero planFinanciero;

}
