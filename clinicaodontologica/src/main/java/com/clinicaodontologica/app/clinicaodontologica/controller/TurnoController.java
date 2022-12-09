package com.clinicaodontologica.app.clinicaodontologica.controller;

import com.clinicaodontologica.app.clinicaodontologica.dto.TurnoDTO;
import com.clinicaodontologica.app.clinicaodontologica.servicios.TurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    private final TurnoServicio turnoServicio;

    @Autowired
    public TurnoController(TurnoServicio turnoServicio) {
        this.turnoServicio = turnoServicio;
    }
    @RequestMapping
    public TurnoDTO crearTurno (@RequestBody TurnoDTO turnoDTO){
        return turnoServicio.crear(turnoDTO);
    }

    @GetMapping
    public List<TurnoDTO> buscarTodosLosTurnos() {
        return turnoServicio.listar();
    }
    @GetMapping("/{idTurno}")
    public TurnoDTO buscarTurnoPorId(@PathVariable Integer idTurno){
        return turnoServicio.buscarPorId(idTurno);
    }

    @GetMapping("/buscarPorUnicoIdTurno/{idTurno}")
    public TurnoDTO buscarPorIdTurno(@PathVariable Integer idTurno){
        return turnoServicio.buscarPorUnicoIdTurno(idTurno);
    }

    @PutMapping
    public TurnoDTO modificarTurno(@RequestBody TurnoDTO turnoDTO) {
        return turnoServicio.modificar(turnoDTO);
    }

  @DeleteMapping("/eliminar/{idTurno}")
  public void eliminarTurno(@PathVariable Integer idTurno) {
        turnoServicio.eliminar(idTurno);
  }

}
