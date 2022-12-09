package com.clinicaodontologica.app.clinicaodontologica.repositorio;

import com.clinicaodontologica.app.clinicaodontologica.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    Paciente findByDni(String dni);
}
