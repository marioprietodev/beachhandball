package com.beachhandball.beachhandball.controller;

import com.beachhandball.beachhandball.entity.Jugador;
import com.beachhandball.beachhandball.repository.JugadorRepository;
import com.beachhandball.beachhandball.service.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JugadorController {
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }
    @GetMapping ("/jugadores")
    public List<Jugador> listarJugadores(){
        return jugadorService.listarJugadores();
    }
    @GetMapping ("/jugadores/{id}")
    public Jugador buscarIdJugador(@PathVariable Long id){
        return jugadorService.buscarIdJugador(id);
    }
    @PostMapping ("/jugadores/crear")
    public Jugador crearJugador(@RequestBody Jugador jugador){
        return jugadorService.crearJugador(jugador);
    }
    @DeleteMapping ("/jugadores/eliminar/{id}")
    public void eliminarJugador(@PathVariable Long id){
       jugadorService.eliminarJugador(id);
    }
    @PutMapping ("/jugadores/actualizar/{id}")
    public void actualizarJugador (@RequestBody Jugador jugador, @PathVariable Long id){
        jugadorService.actualizarJugador(jugador,id);
    }
}
