package com.procesos.demo.repository.empresario.diagnosticoEmpresarial;

import com.procesos.demo.entity.ProcesoEmpresario;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.DiagnosticoEmpresarial;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiagnosticoEmpresarialRepositorio extends MongoRepository<DiagnosticoEmpresarial, Long> {
}
