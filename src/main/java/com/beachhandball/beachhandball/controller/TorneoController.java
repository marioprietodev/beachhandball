package com.beachhandball.beachhandball.controller;

import com.beachhandball.beachhandball.entity.Torneo;
import com.beachhandball.beachhandball.repository.TorneoRepository;
import com.beachhandball.beachhandball.service.TorneoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TorneoController {
private final TorneoService torneoService;
private final TorneoRepository torneoRepository;


    public TorneoController(TorneoService torneoService, TorneoRepository torneoRepository) {
        this.torneoService = torneoService;
        this.torneoRepository = torneoRepository;
    }
    @GetMapping("/torneos")
    public List<Torneo> listarTorneo(){
        return torneoService.listarTorneo();
    }
    @PostMapping ("/torneos/crear")
    public Torneo crearTorneo(@RequestBody Torneo torneo){
        return torneoService.crearTorneo(torneo);
    }
    @GetMapping ("/torneos/{id}")
    public Torneo buscarIdTorneo(@PathVariable Long id){
        return torneoService.buscarIdTorneo(id);
    }
    @DeleteMapping ("/torneos/eliminar/{id}")
    public void eliminar (@PathVariable Long id){
        torneoService.eliminar(id);

    }
}
