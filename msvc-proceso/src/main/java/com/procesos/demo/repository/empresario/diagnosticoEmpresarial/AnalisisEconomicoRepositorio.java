package com.procesos.demo.repository.empresario.diagnosticoEmpresarial;

import com.procesos.demo.entity.ProcesoEmpresario;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.AnalisisEconomico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnalisisEconomicoRepositorio extends MongoRepository<AnalisisEconomico, Long> {
}
