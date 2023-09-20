package com.cliente.msvccliente.controller;

import com.cliente.msvccliente.MsvcUsuario.Usuario;
import com.cliente.msvccliente.entity.Cliente;
import com.cliente.msvccliente.entity.Emprendedor;
import com.cliente.msvccliente.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
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
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody String json, BindingResult result){

        ObjectMapper objectMapper = new ObjectMapper();


        try {

            Emprendedor emprendedor = objectMapper.readValue(json, Emprendedor.class);

            System.out.println(emprendedor);

            return ResponseEntity.ok("Solicitud POST procesada con éxito");

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Error en el formato JSON");
        }

        /*if (result.hasErrors()){
            this.validar((result));
        }
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(clienteService.save());*/
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
}
