package com.procesos.demo.entity;
import com.procesos.demo.entity.modelo.Cliente;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;


@Document(collection = "procesos")
@Data
public class Proceso {
    @Field(targetType = FieldType.OBJECT_ID)

    private String id;
    private Cliente cliente;
    private Long idCliente;

    private String estadoDelProceso;


    private Date fechaCreacion;


    private Date fechaModificacion;

    private ProcesoEmprendedor procesoEmprendedor;

    private ProcesoEmpresario procesoEmpresario;
}
