package com.beachhandball.beachhandball.service;

import com.beachhandball.beachhandball.entity.Jugador;
import com.beachhandball.beachhandball.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    // Crear jugador
    public Jugador crearJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // Listar jugadores
    public List<Jugador> listarJugadores() {
        return jugadorRepository.findAll();
    }

    // Buscar jugador por ID
    public Jugador buscarIdJugador(Long id) {
        return jugadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }
    // Eliminar jugador
    public void eliminarJugador(Long id){
        jugadorRepository.deleteById(id);
    }
    // Editar jugador por ID
    public void actualizarJugador(Jugador jugador, Long id){
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        if (jugadorOptional.isPresent()){
            Jugador jugadorBD = jugadorOptional.get();
            jugadorBD.setNombre(jugador.getNombre());
            jugadorBD.setEspecialidad(jugador.getEspecialidad());
            jugadorBD.setEdad(jugador.getEdad());
            jugadorRepository.save(jugadorBD);
        } else {
            System.out.println("Jugador no encontrado");
        }
    }
}
