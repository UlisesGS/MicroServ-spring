package com.procesos.demo.service.emprendedor;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.emprendedor.AutoEvaluacion;
import com.procesos.demo.repository.ProcesoEmprendedorRepositorio;
import com.procesos.demo.repository.emprendedor.AutoEvaluacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcesoEmprendedorServiceImpl implements ProcesoEmprendedorService {

    @Autowired
    private ProcesoEmprendedorRepositorio procesoEmprendedorRepositorio;

    @Autowired
    private AutoEvaluacionRepositorio autoEvaluacionRepositorio;

    @Override
    public List<ProcesoEmprendedor> findAll() {
        return procesoEmprendedorRepositorio.findAll();
    }

    @Override
    public Optional<ProcesoEmprendedor> findById(Long id) {
        return procesoEmprendedorRepositorio.findById(id);
    }

    @Override
    public ProcesoEmprendedor save(ProcesoEmprendedor proceso) {
        return procesoEmprendedorRepositorio.save(proceso);
    }

    @Override
    public void deleteById(Long id) {
        procesoEmprendedorRepositorio.deleteById(id);
    }

    @Override
    public AutoEvaluacion saveAutoEvaluacion(AutoEvaluacion autoEvaluacion) {
        return autoEvaluacionRepositorio.save(autoEvaluacion);
    }
}
