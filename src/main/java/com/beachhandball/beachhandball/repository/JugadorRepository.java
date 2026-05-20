package com.beachhandball.beachhandball.repository;

import com.beachhandball.beachhandball.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JugadorRepository extends JpaRepository<Jugador,Long> {
}
