/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cliente.msvccliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cliente.msvccliente.entity.Emprendedor;

/**
 *
 * @author crowl
 */
public interface EmprendedorRepository extends JpaRepository<Emprendedor, Long>{
    
}
