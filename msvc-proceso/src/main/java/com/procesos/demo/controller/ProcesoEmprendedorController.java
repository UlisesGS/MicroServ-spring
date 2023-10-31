package com.procesos.demo.controller;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.modelo.Cliente;
import com.procesos.demo.entity.modelo.ClienteService;
import com.procesos.demo.service.IProcesoService;
import com.procesos.demo.service.emprendedor.ProcesoEmprendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")

public class ProcesoEmprendedorController {

    @Autowired
    private IProcesoService procesoService;
    @Autowired
    private ProcesoEmprendedorService emprendedorService;
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/analisisInternoExterno/guardar")
    public ResponseEntity<?> savePlanNegocio(@RequestBody Proceso proceso){
        Cliente cliente = clienteService.findById(proceso.getIdCliente());
        if(cliente != null){
            emprendedorService.saveAnalisis(proceso.getProcesoEmprendedor().getPlanNegocio().getAnalisis());
            emprendedorService.save(proceso.getProcesoEmprendedor());
            return ResponseEntity.status(201).body(procesoService.save(proceso));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/actividadClave")
    public ResponseEntity<?>saveActividadClave(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


           procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
           procesoDb.getProcesoEmprendedor().getCanvas().setActividadClave(emprendedorService.saveActividadClave(proceso.getProcesoEmprendedor().getCanvas().getActividadClave()));
           procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

           return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
       return ResponseEntity.notFound().build();
    }

    

    @PostMapping("/canales")
    public ResponseEntity<?>saveCanales(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);

                procesoDb.getProcesoEmprendedor().getCanvas().setCanales(emprendedorService.saveCanales(proceso.getProcesoEmprendedor().getCanvas().getCanales()));



            emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas());
            emprendedorService.save(proceso.getProcesoEmprendedor());
            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/actividadClave/editar")
    public ResponseEntity<?>updateActividadClave(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().getCanvas().getActividadClave().setActividadPricipal(proceso.getProcesoEmprendedor().getCanvas().getActividadClave().getActividadPricipal());
            procesoDb.getProcesoEmprendedor().getCanvas().getActividadClave().setComunicacionMarketing(proceso.getProcesoEmprendedor().getCanvas().getActividadClave().getComunicacionMarketing());
            procesoDb.getProcesoEmprendedor().getCanvas().getActividadClave().setPostVenta(proceso.getProcesoEmprendedor().getCanvas().getActividadClave().getPostVenta());
            procesoDb.getProcesoEmprendedor().getCanvas().getActividadClave().setOtros(proceso.getProcesoEmprendedor().getCanvas().getActividadClave().getOtros());

            emprendedorService.saveCanvas(procesoDb.getProcesoEmprendedor().getCanvas());

            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }



    @PutMapping("/canales/editar")
    public ResponseEntity<?>updateCanales(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);

            procesoDb.getProcesoEmprendedor().getCanvas().getCanales().setInformacion(proceso.getProcesoEmprendedor().getCanvas().getCanales().getInformacion());
            procesoDb.getProcesoEmprendedor().getCanvas().getCanales().setEvaluacion(proceso.getProcesoEmprendedor().getCanvas().getCanales().getEvaluacion());
            procesoDb.getProcesoEmprendedor().getCanvas().getCanales().setCompra(proceso.getProcesoEmprendedor().getCanvas().getCanales().getCompra());
            procesoDb.getProcesoEmprendedor().getCanvas().getCanales().setEntrega(proceso.getProcesoEmprendedor().getCanvas().getCanales().getEntrega());
            procesoDb.getProcesoEmprendedor().getCanvas().getCanales().setPostVenta(proceso.getProcesoEmprendedor().getCanvas().getCanales().getPostVenta());



            emprendedorService.saveCanvas(procesoDb.getProcesoEmprendedor().getCanvas());
            emprendedorService.save(procesoDb.getProcesoEmprendedor());
            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }



////////////////

    @PostMapping("/estructuraCosto")
    public ResponseEntity<?>saveEstructuraCosto(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setEstructuraCosto(emprendedorService.saveEstructuraCosto(proceso.getProcesoEmprendedor().getCanvas().getEstructuraCosto()));
            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/flujoDeIngreso")
    public ResponseEntity<?>saveFlujoDeIngreso(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setFlujoDeIngreso(emprendedorService.saveFlujoDeIngreso(proceso.getProcesoEmprendedor().getCanvas().getFlujoDeIngreso()));
            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/propuestaValor")
    public ResponseEntity<?>savePropuestaValor(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setPropuestaValor(emprendedorService.savePropuestaValor(proceso.getProcesoEmprendedor().getCanvas().getPropuestaValor()));
            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/recursosClave")
    public ResponseEntity<?>saveRecursosClave(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setRecursoClave(emprendedorService.saveRecursoClave(proceso.getProcesoEmprendedor().getCanvas().getRecursoClave()));
            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/relacionCliente")
    public ResponseEntity<?>saveRelacionCliente(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setRelacionCliente(emprendedorService.saveRelacionCliente(proceso.getProcesoEmprendedor().getCanvas().getRelacionCliente()));
            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/segmentoCliente")
    public ResponseEntity<?>saveSegmentoCliente(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setSegmentoCliente(emprendedorService.saveSegmentoCliente(proceso.getProcesoEmprendedor().getCanvas().getSegmentoCliente()));
            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/socioCLave")
    public ResponseEntity<?>SocioCLave(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            System.out.println(procesoDb);


            procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.saveCanvas(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setSocioCLave(emprendedorService.saveSocioCLave(proceso.getProcesoEmprendedor().getCanvas().getSocioCLave()));
            procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();
    }
}
