package com.procesos.demo.repository.emprendedor;

import com.procesos.demo.entity.emprendedor.AutoEvaluacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutoEvaluacionRepositorio extends MongoRepository<AutoEvaluacion, String> {
}
