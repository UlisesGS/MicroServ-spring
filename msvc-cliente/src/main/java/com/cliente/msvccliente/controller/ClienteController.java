package com.cliente.msvccliente.controller;

import com.cliente.msvccliente.MsvcUsuario.Usuario;
import com.cliente.msvccliente.entity.Cliente;
import com.cliente.msvccliente.entity.Emprendedor;
import com.cliente.msvccliente.entity.Empresario;
import com.cliente.msvccliente.repository.EmprendedorRepository;
import com.cliente.msvccliente.repository.EmpresarioRepository;
import com.cliente.msvccliente.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import java.io.IOException;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired 
    private EmprendedorRepository emprendedorRepository;

    @Autowired
    private EmpresarioRepository empresarioRepository;

    private ResponseEntity<?>validar (BindingResult result){
        Map<String, Object>errores= new HashMap<>();
        result.getFieldErrors().forEach(error->{
            errores.put(error.getField(),"el campo: " + error.getField() + " " + error.getDefaultMessage() );

        });
        return ResponseEntity.badRequest().body(errores);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Cliente>optionalCliente = clienteService.findById(id);
        Cliente cliente = new Cliente();

        if (optionalCliente.isPresent()){
            cliente = optionalCliente.get();
            return ResponseEntity.ok().body(cliente);

        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id){
        Optional<Cliente>optionalCliente = clienteService.findById(id);
        Cliente clienteDb=null;

        if (optionalCliente.isPresent()){
            clienteDb = optionalCliente.get();

            Optional<Usuario>optionalUsuario = clienteService.findByIdUsuario(clienteDb.getUsuario());

            if (optionalUsuario.isPresent()){
                clienteDb.setNombre(cliente.getNombre());
                clienteDb.setApellido(cliente.getApellido());
                clienteDb.setDni(cliente.getDni());
                clienteDb.setGenero(cliente.getGenero());
                clienteDb.setNivelEstudio(cliente.getNivelEstudio());
                clienteDb.setEtnia(cliente.getEtnia());
                clienteDb.setVictima(cliente.getVictima());
                clienteDb.setDiscapacidad(cliente.getDiscapacidad());
                clienteDb.setDesplazamiento(cliente.getDesplazamiento());
                clienteDb.setTelefono(cliente.getTelefono());
                clienteDb.setEmail(cliente.getEmail());
                clienteDb.setFechaNacimiento(cliente.getFechaNacimiento());
                clienteDb.setMunicipio(cliente.getMunicipio());
                clienteDb.setDireccion(cliente.getDireccion());
                clienteDb.setComentario(cliente.getComentario());
                clienteDb.setActivo(cliente.getActivo());
                
                
                
                return ResponseEntity.status(org.apache.http.HttpStatus.SC_CREATED).body(clienteService.save(clienteDb));
            }
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.notFound().build();
    }

    @PutMapping("/convertirEmprendedor/{id}")
    public ResponseEntity<?> convertirAEmpresario(@PathVariable Long id, @RequestBody Empresario empresario){
        Emprendedor emprendedor = (Emprendedor) clienteService.findById(id).get();
        Empresario empresarioDb = new Empresario();

        System.out.println(empresario);

            empresarioDb.setNombre(emprendedor.getNombre());
            empresarioDb.setNombre(emprendedor.getNombre());
            empresarioDb.setApellido(emprendedor.getApellido());
            empresarioDb.setDni(emprendedor.getDni());
            empresarioDb.setGenero(emprendedor.getGenero());
            empresarioDb.setNivelEstudio(emprendedor.getNivelEstudio());
            empresarioDb.setEtnia(emprendedor.getEtnia());
            empresarioDb.setVictima(emprendedor.getVictima());
            empresarioDb.setDiscapacidad(emprendedor.getDiscapacidad());
            empresarioDb.setDesplazamiento(emprendedor.getDesplazamiento());
            empresarioDb.setTelefono(emprendedor.getTelefono());
            empresarioDb.setEmail(emprendedor.getEmail());
            empresarioDb.setFechaNacimiento(emprendedor.getFechaNacimiento());
            empresarioDb.setMunicipio(emprendedor.getMunicipio());
            empresarioDb.setDireccion(emprendedor.getDireccion());
            empresarioDb.setComentario(emprendedor.getComentario());
            empresarioDb.setActivo(emprendedor.getActivo());
            empresarioDb.setFormaContratacion1(empresario.getFormaContratacion1());
            empresarioDb.setFormaContratacion2(empresario.getFormaContratacion2());
            empresarioDb.setNombreEmpresa(empresario.getNombreEmpresa());
            empresarioDb.setFechaAlta(empresario.getFechaAlta());
            empresarioDb.setTipoEmpresa(empresario.getTipoEmpresa());
            empresarioDb.setEmpleadoTC(empresario.getEmpleadoMT());
            empresarioDb.setRegistroMercantil(empresario.getRegistroMercantil());
            empresarioDb.setNumeroRegistroMercantil(empresario.getNumeroRegistroMercantil());
            empresarioDb.setCiiu(empresario.getCiiu());
            empresarioDb.setEmpleadoMT(empresario.getEmpleadoMT());
            empresarioDb.setId(emprendedor.getId());
            empresarioDb.setTipo("empresario");

            emprendedorRepository.deleteById(emprendedor.getId());

            return ResponseEntity.status(HttpStatus.SC_CREATED).body(clienteService.save(empresarioDb));

    }


    @PutMapping("/convertirEmpresario/{id}")
    public ResponseEntity<?> convertirAEmprendedor(@PathVariable Long id, @RequestBody Emprendedor emprendedor){
        Empresario empresario = (Empresario) clienteService.findById(id).get();
        Emprendedor emprendedorDb = new Emprendedor();




        emprendedorDb.setNombre(empresario.getNombre());
        emprendedorDb.setApellido(empresario.getApellido());
        emprendedorDb.setDni(empresario.getDni());
        emprendedorDb.setGenero(empresario.getGenero());
        emprendedorDb.setNivelEstudio(empresario.getNivelEstudio());
        emprendedorDb.setEtnia(empresario.getEtnia());
        emprendedorDb.setVictima(empresario.getVictima());
        emprendedorDb.setDiscapacidad(empresario.getDiscapacidad());
        emprendedorDb.setDesplazamiento(empresario.getDesplazamiento());
        emprendedorDb.setTelefono(empresario.getTelefono());
        emprendedorDb.setEmail(empresario.getEmail());
        emprendedorDb.setFechaNacimiento(empresario.getFechaNacimiento());
        emprendedorDb.setMunicipio(empresario.getMunicipio());
        emprendedorDb.setDireccion(empresario.getDireccion());
        emprendedorDb.setComentario(empresario.getComentario());
        emprendedorDb.setActivo(empresario.getActivo());
        emprendedorDb.setIdeaNegocio(emprendedor.getIdeaNegocio());
        emprendedorDb.setProducto(emprendedor.getProducto());
        emprendedorDb.setTipo("emprendedor");

        emprendedorDb.setId(empresario.getId());

        empresarioRepository.deleteById(empresario.getId());

        return ResponseEntity.status(HttpStatus.SC_CREATED).body(clienteService.save(emprendedorDb));

    }



    @PostMapping("/emprendedor")
    public ResponseEntity<?> saveEmprendedor(@Valid @RequestBody Emprendedor emprendedor, BindingResult result){

        if (result.hasErrors()){
            this.validar((result));
        }

        return ResponseEntity.status(HttpStatus.SC_CREATED).body(emprendedorRepository.save(emprendedor));
    }


    @PostMapping("/empresario")
    public ResponseEntity<?> saveEmpresario(@Valid @RequestBody Empresario empresario, BindingResult result){

        if (result.hasErrors()){
            this.validar((result));
        }

        return ResponseEntity.status(HttpStatus.SC_CREATED).body(empresarioRepository.save(empresario));
    }




}
