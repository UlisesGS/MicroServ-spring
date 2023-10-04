package com.procesos.demo.entity;

import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.DiagnosticoEmpresarial;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "proceso_empresario")
@Data
public class ProcesoEmpresario {

    @Field(targetType = FieldType.OBJECT_ID)
    private Long id;

    private DiagnosticoEmpresarial diagnosticoEmpresarial;
}
