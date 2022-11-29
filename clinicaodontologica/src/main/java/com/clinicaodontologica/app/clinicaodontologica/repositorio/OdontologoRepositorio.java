package com.clinicaodontologica.app.clinicaodontologica.repositorio;

import com.clinicaodontologica.app.clinicaodontologica.entities.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepositorio extends JpaRepository<Odontologo, Integer> {
    @Query("from Odontologo o where o.matricula = ?1")
    Odontologo findByMatricula(String matricula);
}
