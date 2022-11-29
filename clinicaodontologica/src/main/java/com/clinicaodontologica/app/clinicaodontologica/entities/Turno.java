package com.clinicaodontologica.app.clinicaodontologica.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;
    private int idOdontologo;
    private int idPaciente;
    private LocalDateTime fechaTurno;

    public Turno() {
    }

    public Turno(int idTurno, int idOdontologo, int idPaciente, LocalDateTime fechaTurno) {
        this.idTurno = idTurno;
        this.idOdontologo = idOdontologo;
        this.idPaciente = idPaciente;
        this.fechaTurno = fechaTurno;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDateTime getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(LocalDateTime fechaTurno) {
        this.fechaTurno = fechaTurno;
    }
}
