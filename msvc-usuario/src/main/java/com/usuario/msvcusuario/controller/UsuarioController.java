package com.usuario.msvcusuario.controller;

import com.usuario.msvcusuario.entity.Usuario;
import com.usuario.msvcusuario.enumeraciones.Role;
import com.usuario.msvcusuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private ResponseEntity<?>validar (BindingResult result){
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(error->{
            errores.put(error.getField(),"el campo: " + error.getField() + " " + error.getDefaultMessage() );

        });
       return ResponseEntity.badRequest().body(errores);

    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        Optional<Usuario> optionalUsuario = usuarioService.findById(id);
        Usuario usuario = new Usuario();
        if (optionalUsuario.isPresent()){
            usuario = optionalUsuario.get();
        return ResponseEntity.ok().body(usuario);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<?>save(@Valid @RequestBody Usuario usuario, BindingResult result){
        if(result.hasErrors()){
            this.validar(result);
        }
        usuario.setRole(Role.ASESOR);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(usuarioService.save(usuario));

    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@Valid @RequestBody Usuario usuario, BindingResult result,@PathVariable Long id ){
        Optional<Usuario>optionalUsuario = usuarioService.findById(id);
        Usuario usuarioDb = null;
        if (optionalUsuario.isPresent()){
            usuarioDb = optionalUsuario.get();
            usuarioDb.setApellido(usuario.getApellido());
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setPassword(usuario.getPassword());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setCedula(usuario.getCedula());
            usuarioDb.setProfesion(usuario.getProfesion());
            usuarioDb.setTelefono(usuario.getTelefono());
            return ResponseEntity.status(HttpStatus.SC_CREATED).body(usuarioService.save(usuarioDb));
        }
        return  ResponseEntity.notFound().build();
    }

}
