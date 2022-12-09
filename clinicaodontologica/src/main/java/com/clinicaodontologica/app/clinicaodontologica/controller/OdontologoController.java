package com.clinicaodontologica.app.clinicaodontologica.controller;

import com.clinicaodontologica.app.clinicaodontologica.dto.OdontologoDTO;
import com.clinicaodontologica.app.clinicaodontologica.excepciones.NoEncontradoException;
import com.clinicaodontologica.app.clinicaodontologica.servicios.OdontologoServicio;
import com.clinicaodontologica.app.clinicaodontologica.servicios.implServicios.OdontologoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    private final OdontologoServicio odontologoServicio;

    @Autowired
    public OdontologoController(OdontologoServicioImpl odontologoServicioImpl) {
        this.odontologoServicio = odontologoServicioImpl;
    }

    @GetMapping
    public List<OdontologoDTO> buscarTodosOdontologos(){
        return odontologoServicio.listar();
    }

    @GetMapping("/{idOdontologo}")
    public OdontologoDTO buscarOdontologoPorId(@PathVariable Integer idOdontologo) throws NoEncontradoException {
        return odontologoServicio.buscarPorId(idOdontologo);
    }

    @GetMapping("/buscarPorMatricula/{matricula}")
    public OdontologoDTO buscarOdontologoPorMatricula(@PathVariable String matricula) {
        return odontologoServicio.buscarPorUnicaMarticula(matricula);
    }

    @PostMapping
    public OdontologoDTO crearOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return odontologoServicio.crear(odontologoDTO);
    }

    @PutMapping
    public OdontologoDTO modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        return odontologoServicio.modificar(odontologoDTO);
    }

    @DeleteMapping("/eliminar/{idOdontologo}")
    public void eliminarOdontologo(@PathVariable Integer idOdontologo) {
        odontologoServicio.eliminar(idOdontologo);
    }
}
