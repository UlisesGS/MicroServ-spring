package com.usuario.msvcusuario.service;

import com.usuario.msvcusuario.entity.Usuario;
import com.usuario.msvcusuario.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepositorio.deleteById(id);
    }
}
