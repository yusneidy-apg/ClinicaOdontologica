package com.clinicaodontologica.app.clinicaodontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {

    private int idTurno;
    private int idOdontologo;
    private int idPaciente;
    private LocalDateTime fechaTurno;

    public TurnoDTO() {
    }

    public TurnoDTO(int idTurno, int idOdontologo, int idPaciente, LocalDateTime fechaTurno) {
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
