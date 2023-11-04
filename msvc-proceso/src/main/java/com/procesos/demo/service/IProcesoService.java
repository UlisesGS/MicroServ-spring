package com.procesos.demo.service;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.modelo.Cliente;

import java.util.List;
import java.util.Optional;

public interface IProcesoService {
    public List<Proceso>findAll();
    public Optional<Proceso>findById(String id);
    public Proceso save (Proceso proceso);
    public void deleteById(String id);
    // de microservicios cliente
    public Cliente findByClienteId(Long id);

    public Proceso findByCliente(Long idCliente);
}
