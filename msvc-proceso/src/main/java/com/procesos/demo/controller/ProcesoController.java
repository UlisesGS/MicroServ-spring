package com.procesos.demo.controller;

import com.procesos.demo.entity.Proceso;
import com.procesos.demo.entity.ProcesoEmprendedor;
import com.procesos.demo.entity.modelo.Cliente;
import com.procesos.demo.entity.modelo.ClienteService;
import com.procesos.demo.service.IProcesoService;
import com.procesos.demo.service.emprendedor.ProcesoEmprendedorService;
import com.procesos.demo.service.empresario.ProcesoEmpresarioService;
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
    private ProcesoEmpresarioService procesoEmpresarioService;

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

            if (cliente.getTipo().equals("emprendedor")){
                proceso.setCliente(cliente);
               // procesoEmprendedorService.saveAutoEvaluacion(proceso.getProcesoEmprendedor().getAutoEvaluacion());
              //  procesoEmprendedorService.save(proceso.getProcesoEmprendedor());
                return ResponseEntity.status(HttpStatus.CREATED).body(procesoService.save(proceso));

            }else{
                proceso.setCliente(cliente);
                procesoEmpresarioService.saveDiagnostico(proceso.getProcesoEmpresario().getDiagnosticoEmpresarial().getDiagnostico());
                procesoEmpresarioService.saveAnalisisResultados(proceso.getProcesoEmpresario().getDiagnosticoEmpresarial().getAnalisisResultados());
                procesoEmpresarioService.saveAnalisisEconomico(proceso.getProcesoEmpresario().getDiagnosticoEmpresarial().getAnalisisEconomico());
                procesoEmpresarioService.saveDiagnosticoEmpresarial(proceso.getProcesoEmpresario().getDiagnosticoEmpresarial());
                procesoEmpresarioService.save(proceso.getProcesoEmpresario());
                return ResponseEntity.status(HttpStatus.CREATED).body(procesoService.save(proceso));
            }

        }
        return ResponseEntity.notFound().build();

    }

}
