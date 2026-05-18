package com.beachhandball.beachhandball.service;

import com.beachhandball.beachhandball.entity.Torneo;
import com.beachhandball.beachhandball.repository.TorneoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        torneoRepository.deleteById(id);
    }
}
