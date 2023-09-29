package com.procesos.demo.entity.emprendedor.modelobasico;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "informacion_proyectos")
@Data
public class InformacionProyecto {
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private String resumen;
    private String problemas;
    private String objetivos;
    private String mision;
    private String vision;
    private String valoresCorporativos;
    private String impactoAmbiental;
    private String impactoSocial;
}
