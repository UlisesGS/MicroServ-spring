package com.procesos.demo.service.emprendedor;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.emprendedor.AutoEvaluacion;
import com.procesos.demo.entity.emprendedor.canvas.*;
import com.procesos.demo.entity.emprendedor.modelobasico.AnalisisInternoExterno;
import com.procesos.demo.entity.emprendedor.modelobasico.DofaAnalisis;
import com.procesos.demo.entity.emprendedor.modelobasico.InformacionProyecto;
import com.procesos.demo.entity.emprendedor.modelobasico.PlanNegocio;
import com.procesos.demo.repository.ProcesoEmprendedorRepositorio;
import com.procesos.demo.repository.emprendedor.AutoEvaluacionRepositorio;
import com.procesos.demo.repository.emprendedor.canvas.*;
import com.procesos.demo.repository.emprendedor.modelobasico.AnalisisInternoExternoRepositorio;
import com.procesos.demo.repository.emprendedor.modelobasico.DofaAnalisisRepositorio;
import com.procesos.demo.repository.emprendedor.modelobasico.InformacionProyectoRepositorio;
import com.procesos.demo.repository.emprendedor.modelobasico.PlanNegocioRepositorio;
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

    @Autowired
    private AnalisisInternoExternoRepositorio analisisRepositorio;
    @Autowired
    private DofaAnalisisRepositorio dofaRepositorio;
    @Autowired
    private InformacionProyectoRepositorio informacionRepositorio;
    @Autowired
    private PlanNegocioRepositorio planRepositorio;
    // modelo canvas
    @Autowired
    private ActividadClaveRepositorio actividadClaveRepositorio;
    @Autowired
    private CanalesRepositorio canalesRepositorio;
    @Autowired
    private CanvasRepositorio canvasRepositorio;
    @Autowired
    private ComponenteCostoRepositorio componenteCostoRepositorio;
    @Autowired
    private EstructuraCostoRepositorio estructuraCostoRepositorio;
    @Autowired
    private FlujoDeIngresoRepositorio flujoDeIngresoRepositorio;
    @Autowired
    private PropuestaValorRepositorio propuestaValorRepositorio;
    @Autowired
    private RecursoClaveRepositorio recursoClaveRepositorio;
    @Autowired
    private RelacionClienteRepositorio relacionClienteRepositorio;
    @Autowired
    private SegmentoClienteRepositorio segmentoClienteRepositorio;
    @Autowired
    private SocioClaveRepositorio socioClaveRepositorio;

    @Override
    public List<ProcesoEmprendedor> findAll() {
        return procesoEmprendedorRepositorio.findAll();
    }

    @Override
    public Optional<ProcesoEmprendedor> findById(String id) {
        return procesoEmprendedorRepositorio.findById(id);
    }

    @Override
    public ProcesoEmprendedor save(ProcesoEmprendedor proceso) {
        return procesoEmprendedorRepositorio.save(proceso);
    }

    @Override
    public void deleteById(String id) {
        procesoEmprendedorRepositorio.deleteById(id);
    }

    @Override
    public AutoEvaluacion saveAutoEvaluacion(AutoEvaluacion autoEvaluacion) {
        return autoEvaluacionRepositorio.save(autoEvaluacion);
    }

    //modelo basico
    @Override
    public AnalisisInternoExterno saveAnalisis(AnalisisInternoExterno analisisInternoExterno) {
        return analisisRepositorio.save(analisisInternoExterno);
    }

    @Override
    public DofaAnalisis saveDofa(DofaAnalisis dofa) {
        return dofaRepositorio.save(dofa);
    }

    @Override
    public InformacionProyecto saveInformacionProyecto(InformacionProyecto informacionProyecto) {
        return informacionRepositorio.save(informacionProyecto);
    }

    @Override
    public PlanNegocio savePlanNegocio(PlanNegocio planNegocio) {
        return planRepositorio.save(planNegocio);
    }
// modelo canvas
    @Override
    public ActividadClave saveActividadClave(ActividadClave actividadClave) {
        return actividadClaveRepositorio.save(actividadClave);
    }

    @Override
    public Canales saveCanales(Canales canales) {
        return canalesRepositorio.save(canales);
    }

    @Override
    public Canvas saveCanvas(Canvas canvas) {
        return canvasRepositorio.save(canvas);
    }

    @Override
    public ComponenteCosto saveComponenteCosto(ComponenteCosto componenteCosto) {
        return componenteCostoRepositorio.save(componenteCosto);
    }

    @Override
    public EstructuraCosto saveEstructuraCosto(EstructuraCosto estructuraCosto) {
        return estructuraCostoRepositorio.save(estructuraCosto);
    }

    @Override
    public FlujoDeIngreso saveFlujoDeIngreso(FlujoDeIngreso flujoDeIngreso) {
        return flujoDeIngresoRepositorio.save(flujoDeIngreso);
    }

    @Override
    public PropuestaValor savePropuestaValor(PropuestaValor propuestaValor) {
        return propuestaValorRepositorio.save(propuestaValor);
    }

    @Override
    public RecursoClave saveRecursoClave(RecursoClave recursoClave) {
        return recursoClaveRepositorio.save(recursoClave);
    }

    @Override
    public RelacionCliente saveRelacionCliente(RelacionCliente relacionCliente) {
        return relacionClienteRepositorio.save(relacionCliente);
    }

    @Override
    public SegmentoCliente saveSegmentoCliente(SegmentoCliente segmentoCliente) {
        return segmentoClienteRepositorio.save(segmentoCliente);
    }

    @Override
    public SocioCLave saveSocioCLave(SocioCLave socioCLave) {
        return socioClaveRepositorio.save(socioCLave);
    }
}
