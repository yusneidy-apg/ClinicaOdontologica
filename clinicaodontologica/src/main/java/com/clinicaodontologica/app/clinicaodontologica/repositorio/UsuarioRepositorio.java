package com.clinicaodontologica.app.clinicaodontologica.repositorio;

import com.clinicaodontologica.app.clinicaodontologica.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
