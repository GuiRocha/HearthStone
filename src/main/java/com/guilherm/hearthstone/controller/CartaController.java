package com.guilherm.hearthstone.controller;
import com.guilherm.hearthstone.model.Carta;
import com.guilherm.hearthstone.repository.CartaRepository;
import com.guilherm.hearthstone.service.CartaService;
import com.guilherm.hearthstone.util.URL;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "carta")
@RequestMapping(value = "/carta")
public class CartaController {
    @Autowired
    private CartaRepository cartaRepository;
    @Autowired
    private CartaService cartaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Carta>> findAll() {
        List<Carta> list = cartaService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Carta> findById(@PathVariable Long id) {
        Carta obj = cartaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Carta objCarta) {
        Carta obj = cartaService.insert(objCarta);
        obj = cartaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartaService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @RequestMapping(value="/nome", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Carta>> findByName(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.descodeParam(text);
        List<Carta> list  = cartaService.findByName(text);
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value="/tipo", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <List<Carta>> findByTipo(@RequestParam(value = "codigo", defaultValue = "") Integer tipo) {
        tipo = URL.descodeParamInt(tipo);
        List<Carta> list  = cartaService.findByTipo(tipo);
        return ResponseEntity.ok().body(list);
    }
}
