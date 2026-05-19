package com.beachhandball.beachhandball.service;

import com.beachhandball.beachhandball.entity.Equipo;
import com.beachhandball.beachhandball.repository.EquipoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }
    // Crear equipo
    public Equipo crearEquipo(Equipo equipo){
       return equipoRepository.save(equipo);
    }
    // Listar equipo
    public List<Equipo> listarEquipos (){
       return equipoRepository.findAll();
    }
    // Buscar equipo por ID
    public Equipo buscarIdEquipo(Long id){
        return equipoRepository.findById(id).orElseThrow(()-> new RuntimeException("Equipo no encontrado"));
    }
    // Actualizar equipo
    public void editarEquipo (Long id, Equipo equipo){
        // buscar por id el equipo
        Optional<Equipo> equipoOptional = equipoRepository.findById(id);
        //comprobar si existe
        if (equipoOptional.isPresent()){
            Equipo equipoBD = equipoOptional.get();
            // cambiamos los datos
            equipoBD.setNombre(equipo.getNombre());
            equipoBD.setGenero(equipo.getGenero());
            equipoBD.setTamañoPlantilla(equipo.getTamañoPlantilla());
            // guardamos en base de datos
            equipoRepository.save(equipoBD);
        } else {
            System.out.println("Equipo no encontrado");
        }
    }
    // Eliminar equipo
    public void eliminarEquipo (Long id){
        if (equipoRepository.existsById(id)){
            equipoRepository.deleteById(id);
        } else {
            System.out.println("Equipo no encontrado");
        }
    }
}
