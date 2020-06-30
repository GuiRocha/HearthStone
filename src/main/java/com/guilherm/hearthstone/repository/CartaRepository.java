package com.guilherm.hearthstone.repository;

import com.guilherm.hearthstone.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {
}
