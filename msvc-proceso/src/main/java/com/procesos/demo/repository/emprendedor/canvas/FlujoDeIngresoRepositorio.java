package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.FlujoDeIngreso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlujoDeIngresoRepositorio  extends MongoRepository<FlujoDeIngreso,Long> {
}
