package com.procesos.demo.controller;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.modelo.Cliente;
import com.procesos.demo.entity.modelo.ClienteService;
import com.procesos.demo.service.IProcesoService;
import com.procesos.demo.service.emprendedor.ProcesoEmprendedorService;
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
    private ProcesoEmprendedorService procesoEmprendedorService;

    @Autowired
    private ClienteService clienteService;
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(procesoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
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

    @PostMapping
    public ResponseEntity<?>save(@RequestBody Proceso proceso){
        Cliente cliente = clienteService.findById(proceso.getIdCliente());
        if ( cliente!=null){
            System.out.println("1 "+proceso);
            if (cliente.getTipo().equals("emprendedor")){
                System.out.println(proceso);
                proceso.setCliente(cliente);
                procesoEmprendedorService.saveAutoEvaluacion(proceso.getProcesoEmprendedor().getAutoEvaluacion());
                procesoEmprendedorService.save(proceso.getProcesoEmprendedor());
                System.out.println(proceso);
                return ResponseEntity.status(HttpStatus.CREATED).body(procesoService.save(proceso));
            }//aca va lo de empresario
            /*else{
                proceso.setCliente(cliente);
                procesoEmprendedorService.saveAutoEvaluacion(proceso.getProcesoEmprendedor().getAutoEvaluacion());
                procesoEmprendedorService.save(proceso.getProcesoEmprendedor());
                return ResponseEntity.status(HttpStatus.CREATED).body(procesoService.save(proceso));
            }*/

        }
        return ResponseEntity.notFound().build();

    }

}
