package com.procesos.demo.repository.emprendedor.canvas;

import com.procesos.demo.entity.emprendedor.canvas.RelacionCliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelacionClienteRepositorio extends MongoRepository<RelacionCliente,Long> {

}
