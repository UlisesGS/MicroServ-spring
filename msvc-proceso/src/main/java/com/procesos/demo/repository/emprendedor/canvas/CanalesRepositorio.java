package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.Canales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CanalesRepositorio extends MongoRepository<Canales,Long> {
}
