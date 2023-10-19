package com.procesos.demo.repository.emprendedor.modelobasico;

import com.procesos.demo.entity.emprendedor.modelobasico.DofaAnalisis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DofaAnalisisRepositorio extends MongoRepository<DofaAnalisis,String> {
}
