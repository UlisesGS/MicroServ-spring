package com.procesos.demo.service;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.modelo.Cliente;
import com.procesos.demo.entity.modelo.ClienteService;
import com.procesos.demo.repository.ProcesoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcesoServiceImp implements IProcesoService {
    @Autowired
    private ProcesoRepositorio procesoRepositorio;
    @Autowired
    private ClienteService clienteService;

    @Override
    public List<Proceso> findAll() {
        return procesoRepositorio.findAll();
    }

    @Override
    public Optional<Proceso> findById(String id) {
        return procesoRepositorio.findById(id);
    }

    @Override
    public Proceso save(Proceso proceso) {
        return procesoRepositorio.save(proceso);
    }

    @Override
    public void deleteById(String id) {
        procesoRepositorio.deleteById(id);
    }

    @Override
    public Cliente findByIdCliente(Long id) {
        return clienteService.findById(id);
    }
}
