package com.procesos.demo.controller;

import com.procesos.demo.entity.Proceso;
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
    public ResponseEntity<?> save(@RequestBody Proceso proceso){
        Cliente cliente = clienteService.findById(proceso.getIdCliente());
        if(cliente != null){
            emprendedorService.saveAnalisis(proceso.getProcesoEmprendedor().getPlanNegocio().getAnalisis());
            emprendedorService.save(proceso.getProcesoEmprendedor());
            return ResponseEntity.status(201).body(procesoService.save(proceso));
        }
        return ResponseEntity.notFound().build();
    }

}
