package com.procesos.demo.entity.modelo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "msvc-clientes")
public interface ClienteService {
    @GetMapping("/cliente/{id}")
    public Cliente findById(@PathVariable  Long id);

}
