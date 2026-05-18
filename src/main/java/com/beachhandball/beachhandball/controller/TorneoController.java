package com.beachhandball.beachhandball.controller;

import com.beachhandball.beachhandball.entity.Torneo;
import com.beachhandball.beachhandball.repository.TorneoRepository;
import com.beachhandball.beachhandball.service.TorneoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TorneoController {
private final TorneoService torneoService;


    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }
    @GetMapping("/torneos")
    public List<Torneo> listarTorneo(){
        return torneoService.listarTorneo();
    }
    @PostMapping ("/torneos/crear")
    public Torneo crearTorneo(@RequestBody Torneo torneo){
        return torneoService.crearTorneo(torneo);
    }
}
