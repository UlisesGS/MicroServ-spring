package com.procesos.demo.repository;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.modelo.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProcesoRepositorio extends MongoRepository<Proceso,String> {

    Proceso findByIdCliente(Long idCliente);

   /* @Query("{'alumnoId': ?0, 'preguntaId': { $in: ?1} }")
    public Iterable<Respuesta> findRespuestaByAlumnoByPreguntaIds(Long alumnoId, Iterable<Long> preguntaIds);*/
}
