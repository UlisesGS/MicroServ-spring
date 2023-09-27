package com.procesos.demo.entity;

import com.procesos.demo.entity.modelo.Cliente;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Document(collection = "procesos")
@Data
public class Proceso {
    @Field(targetType = FieldType.OBJECT_ID)

    private String id;
    private Cliente cliente;
    private Long idCliente;
   private ProcesoEmprendedor procesoEmprendedor;
   private ProcesoEmpresario procesoEmpresario;
}
