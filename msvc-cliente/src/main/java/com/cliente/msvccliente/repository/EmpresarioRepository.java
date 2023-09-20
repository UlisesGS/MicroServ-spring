package com.cliente.msvccliente.repository;

import com.cliente.msvccliente.entity.Empresario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresarioRepository extends JpaRepository<Empresario, Long> {
}
