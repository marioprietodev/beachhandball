package com.beachhandball.beachhandball.service;

import com.beachhandball.beachhandball.dto.JugadorRequestDTO;
import com.beachhandball.beachhandball.dto.JugadorResponseDTO;
import com.beachhandball.beachhandball.entity.Equipo;
import com.beachhandball.beachhandball.entity.Jugador;
import com.beachhandball.beachhandball.repository.EquipoRepository;
import com.beachhandball.beachhandball.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;

    public JugadorService(JugadorRepository jugadorRepository, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
    }

    // Crear jugador
    public JugadorResponseDTO crearJugador(JugadorRequestDTO jugadorDTO) {
        Equipo equipo = equipoRepository.findById(jugadorDTO.getEquipoId()).orElseThrow(()->new RuntimeException("No encontrado"));
        Jugador jugador = new Jugador();
        jugador.setNombre(jugadorDTO.getNombre());
        jugador.setEdad(jugadorDTO.getEdad());
        jugador.setEspecialidad(jugadorDTO.getEspecialidad());
        jugador.setEquipo(equipo);
        Jugador jugadorguardado = jugadorRepository.save(jugador);
        return convertirJugadorDTO(jugadorguardado);
    }

    // Listar jugadores
    public List<JugadorResponseDTO> listarJugadores() {
        List<Jugador>jugadores = jugadorRepository.findAll();
        List<JugadorResponseDTO> listaJugador = new ArrayList<>();
        for (Jugador jugador : jugadores){
            JugadorResponseDTO jugadorDTO = convertirJugadorDTO(jugador);
            listaJugador.add(jugadorDTO);
        }
        return listaJugador;

    }

    // Buscar jugador por ID
    public JugadorResponseDTO buscarIdJugador(Long id) {
        Jugador jugador = jugadorRepository.findById(id).orElseThrow(()->new RuntimeException("No encontrado"));
       return convertirJugadorDTO(jugador);
    }
    // Eliminar jugador
    public void eliminarJugador(Long id){
        jugadorRepository.deleteById(id);
    }
    // Editar jugador por ID
    public void actualizarJugador(JugadorRequestDTO jugadorDTO, Long id){
        Optional<Jugador> jugadorOptional = jugadorRepository.findById(id);
        Equipo equipo = equipoRepository.findById(jugadorDTO.getEquipoId()).orElseThrow(()->new RuntimeException("Equipo no encontrado"));
        if (jugadorOptional.isPresent()){
            Jugador jugadorBD = jugadorOptional.get();
            jugadorBD.setNombre(jugadorDTO.getNombre());
            jugadorBD.setEspecialidad(jugadorDTO.getEspecialidad());
            jugadorBD.setEdad(jugadorDTO.getEdad());
            jugadorBD.setEquipo(equipo);
            jugadorRepository.save(jugadorBD);
        } else {
            System.out.println("Jugador no encontrado");
        }
    }
    // Convertir Jugador A DTO
    public JugadorResponseDTO convertirJugadorDTO(Jugador jugador){
        JugadorResponseDTO jugadorResponseDTO = new JugadorResponseDTO();

        jugadorResponseDTO.setNombre(jugador.getNombre());
        jugadorResponseDTO.setEdad(jugador.getEdad());
        jugadorResponseDTO.setEspecialidad(jugador.getEspecialidad());
        jugadorResponseDTO.setNombreEquipo(jugador.getEquipo().getNombre());

        return jugadorResponseDTO;
    }
}
