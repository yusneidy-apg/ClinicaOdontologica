package com.clinicaodontologica.app.clinicaodontologica.repositorio;

import com.clinicaodontologica.app.clinicaodontologica.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepositorio extends JpaRepository<Odontologo, Integer> {
    Odontologo findByMatricula(String matricula);
}
