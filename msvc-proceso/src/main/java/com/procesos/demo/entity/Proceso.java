package com.procesos.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.procesos.demo.entity.modelo.Cliente;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.sql.Timestamp;


@Document(collection = "procesos")
@Data
public class Proceso {
    @Field(targetType = FieldType.OBJECT_ID)

    private Long id;
    private Cliente cliente;
    private Long idCliente;

    private String estadoDelProceso;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaCreacion;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp fechaModificacion;

    private ProcesoEmprendedor procesoEmprendedor;

    private ProcesoEmpresario procesoEmpresario;
}
