package com.procesos.demo.entity.emprendedor.canvas;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "estructura_costos")
@Data
public class EstructuraCosto {

    private List<ComponenteCosto> costoFIjo;
    private List<ComponenteCosto> costoVariable;
    private Double totalCostoFijo;
    private Double totalCostoVariable;
}
