package com.guilherm.hearthstone.controller;
import com.guilherm.hearthstone.model.Carta;
import com.guilherm.hearthstone.repository.CartaRepository;
import com.guilherm.hearthstone.service.CartaService;
import com.guilherm.hearthstone.util.URL;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Carta> getById(@PathVariable Long id) {
        return cartaService.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Carta insert(@RequestBody @Validated Carta obj){
        return cartaRepository.save(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Carta> delete(@PathVariable Long id) {
        return cartaService.findById(id)
                .map(carta -> {
                    cartaService.delete(id);
                    return ResponseEntity.ok(carta);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
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
