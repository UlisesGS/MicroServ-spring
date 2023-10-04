package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.Canvas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CanvasRepositorio extends MongoRepository<Canvas,Long> {
}
