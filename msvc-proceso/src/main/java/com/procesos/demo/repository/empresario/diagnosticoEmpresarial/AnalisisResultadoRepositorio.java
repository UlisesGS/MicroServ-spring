package com.procesos.demo.repository.empresario.diagnosticoEmpresarial;

import com.procesos.demo.entity.ProcesoEmpresario;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.AnalisisResultados;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnalisisResultadoRepositorio extends MongoRepository<AnalisisResultados, Long> {
}
