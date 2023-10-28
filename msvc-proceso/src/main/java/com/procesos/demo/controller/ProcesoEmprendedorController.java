package com.procesos.demo.controller;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.modelo.Cliente;
import com.procesos.demo.entity.modelo.ClienteService;
import com.procesos.demo.service.IProcesoService;
import com.procesos.demo.service.emprendedor.ProcesoEmprendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


           procesoDb.getProcesoEmprendedor().setCanvas(emprendedorService.save(proceso.getProcesoEmprendedor().getCanvas()));
            procesoDb.getProcesoEmprendedor().getCanvas().setActividadClave(emprendedorService.save(proceso.getProcesoEmprendedor().getCanvas().getActividadClave()));
           procesoDb.setProcesoEmprendedor(emprendedorService.save(proceso.getProcesoEmprendedor()));

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
       return ResponseEntity.notFound().build();
    }
  /*  @PostMapping("/canales")
    public ResponseEntity<?>saveCanales(@)*/

}
