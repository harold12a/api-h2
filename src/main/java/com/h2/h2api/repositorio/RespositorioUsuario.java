package com.h2.h2api.repositorio;

import com.h2.h2api.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RespositorioUsuario extends JpaRepository<Usuario,Long> {

}
