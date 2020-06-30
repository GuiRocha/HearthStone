package com.guilherm.hearthstone.service;

import com.guilherm.hearthstone.model.Carta;
import com.guilherm.hearthstone.model.Classe;
import com.guilherm.hearthstone.model.Tipo;
import com.guilherm.hearthstone.repository.CartaRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartaServiceTest {
    @Autowired
    private CartaService cartaService;
    private MockMvc mockMvc;
    @MockBean
    private CartaRepository cartaRepository;
    @Test
    void findAll() {
        when(cartaRepository.findAll()).thenReturn(Stream.of(new Carta(6L, "Assassino Casconero", "Um mero Arqueiro Élfico até se deparar com Sargeras.", 5,7, Tipo.MAGIA, Classe.CACADOR)).collect(Collectors.toList()));
        assertEquals(1, cartaService.findAll().size());
    }

    @Test
    void findById() {
        Carta carta = new Carta(6L, "Assassino Casconero",
                "Um mero Arqueiro Élfico até se deparar com Sargeras.",
                5,7, Tipo.MAGIA, Classe.CACADOR);
        when(cartaRepository.findById(6L)).thenReturn(Optional.of(carta));
    }
    @Test
    void insert(){
        Carta carta = new Carta(null, "Assassino Casconero",
                "Um mero Arqueiro Élfico até se deparar com Sargeras.",
                5,7, Tipo.MAGIA, Classe.CACADOR);

        this.cartaRepository.save(carta);
        assertThat(carta.getId()).isNull();
        assertThat(carta.getNome()).isEqualTo("Assassino Casconero");
        assertThat(carta.getDescricao()).isEqualTo("Um mero Arqueiro Élfico até se deparar com Sargeras.");
        assertThat(carta.getAtaque()).isEqualTo(5);
        assertThat(carta.getDefesa()).isEqualTo(7);
        assertThat(carta.getTipo()).isEqualToComparingFieldByField(Tipo.MAGIA);
        assertThat(carta.getClasse()).isEqualToComparingFieldByField(Classe.CACADOR);
    }
    @Test
    void delete(){
        Carta carta = new Carta(null, "Assassino Casconero",
                "Um mero Arqueiro Élfico até se deparar com Sargeras.",
                5,7, Tipo.MAGIA, Classe.CACADOR);

        this.cartaRepository.save(carta);
        cartaRepository.delete(carta);
        assertThat(cartaRepository.findById(carta.getId())).isEmpty();
    }

}