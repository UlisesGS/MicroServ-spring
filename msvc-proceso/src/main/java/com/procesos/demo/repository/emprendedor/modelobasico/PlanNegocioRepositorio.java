package com.procesos.demo.repository.emprendedor.modelobasico;

import com.procesos.demo.entity.emprendedor.modelobasico.PlanNegocio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanNegocioRepositorio extends MongoRepository<PlanNegocio,String> {
}
