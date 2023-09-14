package com.cliente.msvccliente.MsvcUsuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(name = "msvc-usuarios")
public interface UsuarioService {

    @GetMapping("/{id}")
    public Optional<Usuario> findById(Long id);
}
