package com.beachhandball.beachhandball.service;

import com.beachhandball.beachhandball.entity.Torneo;
import com.beachhandball.beachhandball.repository.TorneoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {
    private final TorneoRepository torneoRepository;

    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }
    // Crear Torneo
    public Torneo crearTorneo(Torneo torneo){
        return torneoRepository.save(torneo);
    }
    // Listar Torneos
    public List<Torneo> listarTorneo(){
        return torneoRepository.findAll();
    }
    // Buscar por ID
    public Torneo buscarIdTorneo(Long id){
        return torneoRepository.findById(id).orElseThrow(()-> new RuntimeException("Torneo no encontrado"));
    }
    // Eliminar torneo
    public void eliminar(Long id){
        if (!torneoRepository.existsById(id)){
            System.out.println("Torneo no encontrado");
        } else {
            torneoRepository.deleteById(id);
        }

    }
    // Updatear torneo
    public void actualizarTorneo(Long id, Torneo torneo){
    // Buscamos en la base de datos
        Optional<Torneo> torneoOptional = torneoRepository.findById(id);
        // Comprobar si existe
        if (torneoOptional.isPresent()){
            // sacamos el objeto
            Torneo torneoBD = torneoOptional.get();
            // actualizamos el objeto
            torneoBD.setNombre(torneo.getNombre());
            torneoBD.setLugar(torneo.getLugar());
            torneoBD.setFecha(torneo.getFecha());
            // guardamos el objeto
            torneoRepository.save(torneoBD);
        } else {
            System.out.println("Torneo no encontrado");
        }

    }

}
