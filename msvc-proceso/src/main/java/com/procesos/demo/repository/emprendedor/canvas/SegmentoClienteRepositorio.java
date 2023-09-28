package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.SegmentoCliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SegmentoClienteRepositorio extends MongoRepository<SegmentoCliente,Long> {
}
