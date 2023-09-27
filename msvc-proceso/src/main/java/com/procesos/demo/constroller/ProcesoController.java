package com.procesos.demo.constroller;

import com.procesos.demo.entity.Proceso;
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

    @PostMapping
    public ResponseEntity<?>save(@RequestBody Proceso proceso){
        Cliente cliente = clienteService.findById(proceso.getIdCliente());
        if ( cliente!=null){
            proceso.setCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(procesoService.save(proceso));
        }
        return ResponseEntity.notFound().build();

    }
}
