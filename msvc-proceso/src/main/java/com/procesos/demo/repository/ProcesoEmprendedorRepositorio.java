package com.procesos.demo.repository;

import com.procesos.demo.entity.ProcesoEmprendedor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcesoEmprendedorRepositorio extends MongoRepository<ProcesoEmprendedor, String> {
}
