package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.RecursoClave;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecursoClaveRepositorio extends MongoRepository<RecursoClave,Long> {
}
