package com.procesos.demo.repository.emprendedor.modelobasico;

import com.procesos.demo.entity.emprendedor.modelobasico.AnalisisInternoExterno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnalisisInternoExternoRepositorio extends MongoRepository<AnalisisInternoExterno,String> {
}
