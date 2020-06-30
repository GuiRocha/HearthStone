package com.guilherm.hearthstone.controller;
import com.guilherm.hearthstone.model.Carta;
import com.guilherm.hearthstone.repository.CartaRepository;
import com.guilherm.hearthstone.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/carta")
public class CartaController {
    @Autowired
    private CartaRepository cartaRepository;
    @Autowired
    private CartaService cartaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Carta>> findAll() {
        List<Carta> list = cartaRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carta> findById(@PathVariable Long id) {
        Carta obj = cartaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Carta objDTO) {
        Carta obj = cartaService.insert(objDTO);
        obj = cartaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
