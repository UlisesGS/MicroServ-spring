package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.ActividadClave;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActividadClaveRepositorio extends MongoRepository<ActividadClave,Long> {
}
