package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "segmento_clientes")
@Data
public class SegmentoCliente {

    private String demograficas;
    private String geografia;
    private String psicograficas;
    private String comportamiento;
}
