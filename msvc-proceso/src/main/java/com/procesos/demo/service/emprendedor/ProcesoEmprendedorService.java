package com.procesos.demo.service.emprendedor;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.emprendedor.AutoEvaluacion;
import com.procesos.demo.entity.emprendedor.modelobasico.AnalisisInternoExterno;
import com.procesos.demo.entity.emprendedor.modelobasico.DofaAnalisis;
import com.procesos.demo.entity.emprendedor.modelobasico.InformacionProyecto;
import com.procesos.demo.entity.emprendedor.modelobasico.PlanNegocio;
import com.procesos.demo.entity.modelo.Cliente;

import java.util.List;
import java.util.Optional;

public interface ProcesoEmprendedorService {

    /* METODOS PARA ProcesoEmprendedor */
    public List<ProcesoEmprendedor> findAll();
    public Optional<ProcesoEmprendedor> findById(Long id);
    public ProcesoEmprendedor save (ProcesoEmprendedor proceso);
    public void deleteById(Long id);



    /* METODOS PARA AutoEvaluacion */
    public AutoEvaluacion saveAutoEvaluacion(AutoEvaluacion autoEvaluacion);


    /*METODOS PARA ModeloBasico*/
    public AnalisisInternoExterno saveAnalisis(AnalisisInternoExterno analisisInternoExterno);

    //dofa
    public DofaAnalisis saveDofa(DofaAnalisis dofa);


    //informacion proyecto
    public InformacionProyecto saveInformacionProyecto(InformacionProyecto informacionProyecto);

    //Plan negocio
    public PlanNegocio savePlanNegocio(PlanNegocio planNegocio);






}
