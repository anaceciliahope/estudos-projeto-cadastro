package com.refazendotodo.estudos.repository;

import com.refazendotodo.estudos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Boolean existsByEmail(String email);
}
