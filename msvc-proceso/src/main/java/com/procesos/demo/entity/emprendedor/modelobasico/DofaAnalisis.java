package com.procesos.demo.entity.emprendedor.modelobasico;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "dofa_analisis")
@Data
public class DofaAnalisis {
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private String debilidades;
    private String oportunidades;
    private String fortalezas;
    private String amenazas;
}
