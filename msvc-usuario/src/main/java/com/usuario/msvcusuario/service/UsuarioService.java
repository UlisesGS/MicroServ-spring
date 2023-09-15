package com.usuario.msvcusuario.service;

import com.usuario.msvcusuario.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<Usuario>findAll();

    public Optional<Usuario>findById(Long id);

    public Usuario save(Usuario usuario);

    public void delete(Long id);
}
