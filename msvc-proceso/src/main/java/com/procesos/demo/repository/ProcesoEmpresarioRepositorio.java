package com.procesos.demo.repository;

import com.procesos.demo.entity.ProcesoEmpresario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcesoEmpresarioRepositorio extends MongoRepository<ProcesoEmpresario, Long> {
}
