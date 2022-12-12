package com.clinicaodontologica.app.clinicaodontologica.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Turno")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTurno")
    private int idTurno;
    @Column(name = "IdOdontologo")
    private int idOdontologo;
    @Column(name = "IdPaciente")
    private int idPaciente;
    @Column(name = "FechaTurno")
    private LocalDateTime fechaTurno;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdOdontologo", referencedColumnName = "IdOdontologo", insertable = false, updatable = false)
    private Odontologo odontologo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdPaciente", referencedColumnName = "IdPaciente", insertable = false, updatable = false)
    private Paciente paciente;

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

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
