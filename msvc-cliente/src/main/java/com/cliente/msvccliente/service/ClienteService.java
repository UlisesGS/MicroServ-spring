package com.cliente.msvccliente.service;

import com.cliente.msvccliente.MsvcUsuario.Usuario;
import com.cliente.msvccliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public List<Cliente>findAll();

    public Optional<Cliente>findById(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);

    public  Optional<Usuario> findByIdUsuario(Long id);
}
