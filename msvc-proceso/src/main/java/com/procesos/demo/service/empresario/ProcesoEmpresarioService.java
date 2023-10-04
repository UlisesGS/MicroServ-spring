package com.procesos.demo.service.empresario;

import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.ProcesoEmpresario;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.AnalisisEconomico;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.AnalisisResultados;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.Diagnostico;
import com.procesos.demo.entity.empresario.diagnosticoEmpresarial.DiagnosticoEmpresarial;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface ProcesoEmpresarioService {



    /* METODOS PARA ProcesoEmpresario */
    public List<ProcesoEmpresario> findAll();

    public Optional<ProcesoEmpresario> findById(Long id);

    public ProcesoEmpresario save (ProcesoEmpresario proceso);

    public void deleteById(Long id);


    /* METODOS PARA diagnosticoEmpresarial */

    public DiagnosticoEmpresarial saveDiagnosticoEmpresarial(DiagnosticoEmpresarial diagnosticoEmpresarial);

    public Diagnostico saveDiagnostico(Diagnostico diagnostico);

    public AnalisisEconomico saveAnalisisEconomico(AnalisisEconomico analisisEconomico);

    public AnalisisResultados saveAnalisisResultados(AnalisisResultados analisisResultados);
}
