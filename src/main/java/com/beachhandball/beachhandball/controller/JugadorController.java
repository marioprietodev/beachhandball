package com.beachhandball.beachhandball.controller;

import com.beachhandball.beachhandball.dto.JugadorRequestDTO;
import com.beachhandball.beachhandball.dto.JugadorResponseDTO;
import com.beachhandball.beachhandball.entity.Jugador;
import com.beachhandball.beachhandball.repository.JugadorRepository;
import com.beachhandball.beachhandball.service.JugadorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Valid
public class JugadorController {
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("/jugadores")
    public List<JugadorResponseDTO> listarJugadores() {
        return jugadorService.listarJugadores();
    }

    @GetMapping("/jugadores/{id}")
    public JugadorResponseDTO buscarIdJugador(@PathVariable Long id) {
        return jugadorService.buscarIdJugador(id);
    }

    @PostMapping("/jugadores/crear")
    public JugadorResponseDTO crearJugador(@RequestBody JugadorRequestDTO jugadorDTO) {
        return jugadorService.crearJugador(jugadorDTO);
    }

    @DeleteMapping("/jugadores/eliminar/{id}")
    public void eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
    }

    @PutMapping("/jugadores/actualizar/{id}")
    public void actualizarJugador(@RequestBody JugadorRequestDTO jugadorDTO, @PathVariable Long id) {
        jugadorService.actualizarJugador(jugadorDTO, id);
    }
}
