package com.procesos.demo.entity.emprendedor.modelobasico;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collation = "plan_negocios")
@Data
public class PlanNegocio {

    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private AnalisisInternoExterno analisis;
    private DofaAnalisis dofaAnalisis;
    private InformacionProyecto informacionProyecto;

}
