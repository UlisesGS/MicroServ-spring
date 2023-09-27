package com.procesos.demo.repository;

import com.procesos.demo.entity.Proceso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcesoRepositorio extends MongoRepository<Proceso,String> {
}
