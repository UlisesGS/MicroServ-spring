package com.procesos.demo.entity.empresario.diagnosticoEmpresarial;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "diagnostico_empresarial")
@Data
public class DiagnosticoEmpresarial {

    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;

    private Diagnostico diagnostico;

    private AnalisisResultados analisisResultados;

    private AnalisisEconomico analisisEconomico;
}
