package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Data
public class ActividadClave {

    private String id;
    private String actividadPricipal;
    private String comunicacionMarketing;
    private String postVenta;
    private String otros;
}
