package com.beachhandball.beachhandball.controller;

import com.beachhandball.beachhandball.entity.Equipo;
import com.beachhandball.beachhandball.service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping("/equipos")
    public List<Equipo> listarEquipos() {
        return equipoService.listarEquipos();
    }

    @GetMapping("/equipos/{id}")
    public Equipo buscarIdEquipo(@PathVariable Long id) {
        return equipoService.buscarIdEquipo(id);
    }

    @PostMapping("/equipos/crear")
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoService.crearEquipo(equipo);
    }

    @PutMapping("/equipos/editar/{id}")
    public void editarEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        equipoService.editarEquipo(id, equipo);
    }

    @DeleteMapping("/equipos/eliminar/{id}")
    public void eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
    }
}
