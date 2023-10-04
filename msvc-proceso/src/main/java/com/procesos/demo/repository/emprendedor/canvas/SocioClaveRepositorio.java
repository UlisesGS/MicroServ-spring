package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.SocioCLave;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocioClaveRepositorio extends MongoRepository<SocioCLave,Long> {
}
