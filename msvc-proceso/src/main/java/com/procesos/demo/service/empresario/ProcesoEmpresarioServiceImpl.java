package com.procesos.demo.service.empresario;

import com.procesos.demo.entity.ProcesoEmpresario;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.AnalisisEconomico;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.AnalisisResultados;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.Diagnostico;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.DiagnosticoEmpresarial;
import com.procesos.demo.repository.ProcesoEmpresarioRepositorio;
import com.procesos.demo.repository.empresario.diagnosticoEmpresarial.AnalisisEconomicoRepositorio;
import com.procesos.demo.repository.empresario.diagnosticoEmpresarial.AnalisisResultadoRepositorio;
import com.procesos.demo.repository.empresario.diagnosticoEmpresarial.DiagnosticoEmpresarialRepositorio;
import com.procesos.demo.repository.empresario.diagnosticoEmpresarial.DiagnosticoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcesoEmpresarioServiceImpl implements ProcesoEmpresarioService {

    @Autowired
    private ProcesoEmpresarioRepositorio procesoEmpresarioRepositorio;

    @Autowired
    private DiagnosticoEmpresarialRepositorio diagnosticoEmpresarialRepositorio;

    @Autowired
    private DiagnosticoRepositorio diagnosticoRepositorio;

    @Autowired
    private AnalisisResultadoRepositorio analisisResultadoRepositorio;

    @Autowired
    private AnalisisEconomicoRepositorio analisisEconomicoRepositorio;

    @Override
    public List<ProcesoEmpresario> findAll() {
        return procesoEmpresarioRepositorio.findAll();
    }

    @Override
    public Optional<ProcesoEmpresario> findById(Long id) {
        return procesoEmpresarioRepositorio.findById(id);
    }

    @Override
    public ProcesoEmpresario save(ProcesoEmpresario proceso) {
        return procesoEmpresarioRepositorio.save(proceso);
    }

    @Override
    public void deleteById(Long id) {
        procesoEmpresarioRepositorio.deleteById(id);
    }


    /* METODOS PARA diagnosticoEmpresarial */

    @Override
    public DiagnosticoEmpresarial saveDiagnosticoEmpresarial(DiagnosticoEmpresarial diagnosticoEmpresarial) {
        return diagnosticoEmpresarialRepositorio.save(diagnosticoEmpresarial);
    }

    @Override
    public Diagnostico saveDiagnostico(Diagnostico diagnostico) {
        return diagnosticoRepositorio.save(diagnostico);
    }

    @Override
    public AnalisisResultados saveAnalisisResultados(AnalisisResultados analisisResultados) {
        return analisisResultadoRepositorio.save(analisisResultados);
    }

    @Override
    public AnalisisEconomico saveAnalisisEconomico(AnalisisEconomico analisisEconomico) {
        return analisisEconomicoRepositorio.save(analisisEconomico);
    }

}
