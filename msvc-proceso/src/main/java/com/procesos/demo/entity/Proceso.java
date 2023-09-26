package com.procesos.demo.entity;

import com.procesos.demo.entity.modelo.Cliente;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "procesos")
@Data
public class Proceso {
    @Id
    private Long id;
    private Cliente cliente;
    private ProcesoEmprendedor procesoEmprendedor;
    private ProcesoEmpresario procesoEmpresario;
}
