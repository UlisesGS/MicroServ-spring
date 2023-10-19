package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@Document(collection = "estructura_costos")
@Data
public class EstructuraCosto {
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private List<ComponenteCosto> costoFIjo;
    private List<ComponenteCosto> costoVariable;
    private Double totalCostoFijo;
    private Double totalCostoVariable;
}
