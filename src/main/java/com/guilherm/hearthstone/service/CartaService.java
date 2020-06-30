package com.guilherm.hearthstone.service;

import com.guilherm.hearthstone.exception.ExceptionError;
import com.guilherm.hearthstone.model.Carta;
import com.guilherm.hearthstone.repository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaService {
    @Autowired
    private CartaRepository cartaRepository;

    public List<Carta> findAll() {
        List<Carta> cartas = cartaRepository.findAll();
        return cartas;
    }
    public Carta findById(Long id){
        Optional<Carta> obj = cartaRepository.findById(id);
        return obj.get();
    }

    public Carta insert(Carta obj){
        return cartaRepository.save(obj);
    }

    public void delete(Long id){
        findById(id);
        cartaRepository.deleteById(id);
    }
    public List<Carta> findByName(String text) {
        return cartaRepository.findByNome(text);
    }
    public List<Carta> findByTipo(Integer tipo) {
        return cartaRepository.findByTipo(tipo);
    }
}
