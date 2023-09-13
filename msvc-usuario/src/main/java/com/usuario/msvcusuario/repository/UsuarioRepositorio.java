package com.usuario.msvcusuario.repository;

import com.usuario.msvcusuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

}
