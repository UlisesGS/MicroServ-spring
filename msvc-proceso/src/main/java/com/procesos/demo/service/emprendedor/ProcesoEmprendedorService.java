package com.procesos.demo.service.emprendedor;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.emprendedor.AutoEvaluacion;
import com.procesos.demo.entity.emprendedor.canvas.*;
import com.procesos.demo.entity.emprendedor.modelobasico.AnalisisInternoExterno;
import com.procesos.demo.entity.emprendedor.modelobasico.DofaAnalisis;
import com.procesos.demo.entity.emprendedor.modelobasico.InformacionProyecto;
import com.procesos.demo.entity.emprendedor.modelobasico.PlanNegocio;
import com.procesos.demo.entity.modelo.Cliente;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Optional;

public interface ProcesoEmprendedorService {

    /* METODOS PARA ProcesoEmprendedor */
    public List<ProcesoEmprendedor> findAll();
    public Optional<ProcesoEmprendedor> findById(String id);
    public ProcesoEmprendedor save (ProcesoEmprendedor proceso);
    public void deleteById(String id);



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
    // modelo canvas
    public ActividadClave save (ActividadClave actividadClave);
    public Canales save (Canales canales);
    public Canvas save (Canvas canvas);
    public ComponenteCosto save (ComponenteCosto componenteCosto);
    public EstructuraCosto save (EstructuraCosto estructuraCosto);
    public FlujoDeIngreso save (FlujoDeIngreso flujoDeIngreso);
    public PropuestaValor save (PropuestaValor propuestaValor);
    public RecursoClave save (RecursoClave recursoClave);
    public RelacionCliente save (RelacionCliente relacionCliente);
    public SegmentoCliente save (SegmentoCliente segmentoCliente);
    public SocioCLave save (SocioCLave socioCLave);






}
