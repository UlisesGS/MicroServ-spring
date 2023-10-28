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
    public ActividadClave saveActividadClave(ActividadClave actividadClave);
    public Canales saveCanales (Canales canales);
    public Canvas saveCanvas (Canvas canvas);
    public ComponenteCosto saveComponenteCosto (ComponenteCosto componenteCosto);
    public EstructuraCosto saveEstructuraCosto (EstructuraCosto estructuraCosto);
    public FlujoDeIngreso saveFlujoDeIngreso (FlujoDeIngreso flujoDeIngreso);
    public PropuestaValor savePropuestaValor (PropuestaValor propuestaValor);
    public RecursoClave saveRecursoClave (RecursoClave recursoClave);
    public RelacionCliente saveRelacionCliente (RelacionCliente relacionCliente);
    public SegmentoCliente saveSegmentoCliente (SegmentoCliente segmentoCliente);
    public SocioCLave saveSocioCLave (SocioCLave socioCLave);






}
