package com.procesos.demo.repository.empresario.diagnosticoEmpresarial;

import com.procesos.demo.entity.ProcesoEmpresario;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.Diagnostico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiagnosticoRepositorio extends MongoRepository<Diagnostico, Long> {
}
