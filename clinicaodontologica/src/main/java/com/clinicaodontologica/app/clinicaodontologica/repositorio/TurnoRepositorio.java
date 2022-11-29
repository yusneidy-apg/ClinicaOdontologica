package com.clinicaodontologica.app.clinicaodontologica.repositorio;

import com.clinicaodontologica.app.clinicaodontologica.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepositorio extends JpaRepository<Turno, Integer> {
}
