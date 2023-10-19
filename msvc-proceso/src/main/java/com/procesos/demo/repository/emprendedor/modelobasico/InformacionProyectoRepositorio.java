package com.procesos.demo.repository.emprendedor.modelobasico;

import com.procesos.demo.entity.emprendedor.modelobasico.InformacionProyecto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InformacionProyectoRepositorio extends MongoRepository<InformacionProyecto,String> {
}
