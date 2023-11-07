package com.procesos.demo.controller;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.modelo.Cliente;
import com.procesos.demo.entity.modelo.ClienteService;
import com.procesos.demo.service.IProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")
public class ProcesoController {
    @Autowired
    private IProcesoService procesoService;


    @Autowired
    private ClienteService clienteService;
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(procesoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable String id){
        Optional<Proceso> procesoOptional = procesoService.findById(id);
        if (procesoOptional.isPresent()){
            return ResponseEntity.ok().body(procesoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/cliente/{id}")
    public ResponseEntity<?>busquedaCliente(@PathVariable Long id){
       Cliente clienteOptional = clienteService.findById(id);
        if (clienteOptional!=null){
            return ResponseEntity.ok().body(clienteOptional);
        }
        return ResponseEntity.notFound().build();


    }


    @GetMapping("/cliente/comprobar/{idCliente}")
    public ResponseEntity<?>comprobarCliente(@PathVariable Long idCliente){

        Proceso clienteOptional = procesoService.findByCliente(idCliente);
        System.out.println("holaaaaa");
        System.out.println(clienteOptional);
        if (clienteOptional!=null){
            System.out.println("entro");
            return ResponseEntity.ok().body(true);
        }else {
            return ResponseEntity.ok().body(false);
        }


    }


    @PostMapping
    public ResponseEntity<?>save(@RequestBody Proceso proceso){
        Cliente cliente = clienteService.findById(proceso.getIdCliente());
        if ( cliente!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(procesoService.save(proceso));

        }
        return ResponseEntity.notFound().build();

    }


    @PutMapping("/editar/procesoEmprendedor")
    public ResponseEntity<?>updateProcesoEmprendedor(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            procesoDb.setProcesoEmprendedor(proceso.getProcesoEmprendedor());

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();

    }


    @PutMapping("/editar/procesoEmpresario")
    public ResponseEntity<?>updateProcesoEmpresario(@RequestBody Proceso proceso){
        Optional<Proceso> procesoOptional = procesoService.findById(proceso.getId());
        Proceso procesoDb = null;
        if(procesoOptional.isPresent()){
            procesoDb = procesoOptional.get();
            procesoDb.setProcesoEmpresario(proceso.getProcesoEmpresario());

            return ResponseEntity.status(201).body(procesoService.save(procesoDb));
        }
        return ResponseEntity.notFound().build();

    }

}
