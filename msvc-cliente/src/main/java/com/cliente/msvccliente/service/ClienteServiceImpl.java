package com.cliente.msvccliente.service;

import com.cliente.msvccliente.MsvcUsuario.Usuario;
import com.cliente.msvccliente.MsvcUsuario.UsuarioService;
import com.cliente.msvccliente.entity.Cliente;
import com.cliente.msvccliente.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public List<Cliente> findAll() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepositorio.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepositorio.deleteById(id);
    }


    // METODOS DE OTRA ENTIDAD
    @Override
    public Optional<Usuario> findByIdUsuario(Long id) {
        return usuarioService.findById(id);
    }
    
    
}
